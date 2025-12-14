package com.jobScheduler.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryJobStore implements JobStore {

	 private final Map<String, JobDetail> jobs = new ConcurrentHashMap<String, JobDetail>();

	    @Override
	    public void saveJob(JobDetail job) {
	        Objects.requireNonNull(job, "job cannot be null");
	        jobs.put(job.getJobId(), job);
	    }

	    @Override
	    public Optional<JobDetail> getJob(String jobId) {
	        return Optional.ofNullable(jobs.get(jobId));
	    }

	    @Override
	    public List<JobDetail> getAllJobs() {
	        return new ArrayList<JobDetail>(jobs.values());
	    }

	    @Override
	    public void updateJob(JobDetail job) {
	        Objects.requireNonNull(job, "job cannot be null");
	        jobs.put(job.getJobId(), job);
	    }

	    @Override
	    public void deleteJob(String jobId) {
	        jobs.remove(jobId);
	    }

}
