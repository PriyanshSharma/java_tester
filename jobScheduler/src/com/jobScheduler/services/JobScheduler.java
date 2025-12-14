package com.jobScheduler.services;



import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.*;

import com.jobScheduler.entity.JobDetail;
import com.jobScheduler.entity.JobHandler;
import com.jobScheduler.entity.JobStatusEnum;
import com.jobScheduler.entity.JobStore;
import com.jobScheduler.entity.JobTrigger;

public class JobScheduler {

    private final JobStore jobStore;
    private final ScheduledExecutorService dispatcherExecutor;
    private final ExecutorService workerPool;
    private final long dispatchIntervalMillis;

    private volatile boolean running = false;
    private ScheduledFuture<?> dispatcherFuture;

    public JobScheduler(JobStore jobStore,
                        int workerThreads,
                        long dispatchIntervalMillis) {
        this.jobStore = Objects.requireNonNull(jobStore, "jobStore is required");
        this.workerPool = Executors.newFixedThreadPool(workerThreads);
        this.dispatcherExecutor = Executors.newSingleThreadScheduledExecutor(r -> {
            Thread t = new Thread(r, "job-scheduler-dispatcher");
            t.setDaemon(true);
            return t;
        });
        this.dispatchIntervalMillis = dispatchIntervalMillis;
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        dispatcherFuture = dispatcherExecutor.scheduleAtFixedRate(
            this::dispatchLoop,
            0,
            dispatchIntervalMillis,
            TimeUnit.MILLISECONDS
        );
    }

    public synchronized void shutdown() {
        running = false;
        if (dispatcherFuture != null) {
            dispatcherFuture.cancel(true);
        }
        dispatcherExecutor.shutdown();
        workerPool.shutdown();
        try {
            dispatcherExecutor.awaitTermination(5, TimeUnit.SECONDS);
            workerPool.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String scheduleJob(JobDetail job) {
        Instant now = Instant.now();
        JobTrigger trigger = job.getTrigger();
        if (job.getNextRunTime() == null) {
            Instant next = trigger.getNextFireTime(null, now);
            job.setNextRunTime(next);
        }
        jobStore.saveJob(job);
        return job.getJobId();
    }

    public void pauseJob(String jobId) {
        jobStore.getJob(jobId).ifPresent(job -> {
            job.setStatus(JobStatusEnum.PAUSED);
            jobStore.updateJob(job);
        });
    }

    public void resumeJob(String jobId) {
        jobStore.getJob(jobId).ifPresent(job -> {
            if (job.getStatus() == JobStatusEnum.PAUSED) {
                job.setStatus(JobStatusEnum.SCHEDULED);
                if (job.getNextRunTime() == null) {
                    Instant now = Instant.now();
                    Instant next = job.getTrigger().getNextFireTime(job.getLastRunTime(), now);
                    job.setNextRunTime(next);
                }
                jobStore.updateJob(job);
            }
        });
    }

    public void cancelJob(String jobId) {
        jobStore.getJob(jobId).ifPresent(job -> {
            job.setStatus(JobStatusEnum.CANCELLED);
            jobStore.updateJob(job);
        });
    }

    public Optional<JobDetail> getJob(String jobId) {
        return jobStore.getJob(jobId);
    }

    public List<JobDetail> getAllJobs() {
        return jobStore.getAllJobs();
    }

    private void dispatchLoop() {
        if (!running) return;

        Instant now = Instant.now();
        List<JobDetail> jobs = jobStore.getAllJobs();

        for (JobDetail job : jobs) {
            if (!shouldRun(job, now)) {
                continue;
            }
            // Mark as RUNNING and update before execution to avoid double-dispatch
            job.setStatus(JobStatusEnum.RUNNING);
            jobStore.updateJob(job);

            workerPool.submit(() -> runJob(job));
        }
    }

    private boolean shouldRun(JobDetail job, Instant now) {
        if (job.getStatus() != JobStatusEnum.SCHEDULED) {
            return false;
        }
        Instant nextRun = job.getNextRunTime();
        return nextRun != null && !nextRun.isAfter(now);
    }

    private void runJob(JobDetail job) {
        JobHandler handler = job.getHandler();
        JobTrigger trigger = job.getTrigger();
        Instant start = Instant.now();
        try {
            handler.execute();
            job.setLastRunTime(start);
            job.resetRetryCount();

            Instant next = trigger.getNextFireTime(job.getLastRunTime(), Instant.now());
            if (next == null) {
                job.setStatus(JobStatusEnum.COMPLETED);
                job.setNextRunTime(null);
            } else {
                job.setStatus(JobStatusEnum.SCHEDULED);
                job.setNextRunTime(next);
            }
        } catch (Exception e) {
            handleJobFailure(job, e);
        } finally {
            jobStore.updateJob(job);
        }
    }

    private void handleJobFailure(JobDetail job, Exception e) {
        int retries = job.getCurrentRetryCount() + 1;
        job.incrementRetryCount();
        if (retries > job.getMaxRetries()) {
            job.setStatus(JobStatusEnum.FAILED);
            job.setNextRunTime(null);
            // In real prod: log error with stacktrace
            return;
        }
        // Simple retry strategy: retry after 1 minute
        Instant retryTime = Instant.now().plusSeconds(60);
        job.setStatus(JobStatusEnum.SCHEDULED);
        job.setNextRunTime(retryTime);
        // In real prod: log warn with details
    }
}
