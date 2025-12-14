package com.jobScheduler.controller;



import java.time.Duration;

import com.jobScheduler.entity.FixedDelayTrigger;
import com.jobScheduler.entity.InMemoryJobStore;
import com.jobScheduler.entity.JobDetail;
import com.jobScheduler.services.JobScheduler;

public class SchedulerExample {
    public static void main(String[] args) throws InterruptedException {
        InMemoryJobStore store = new InMemoryJobStore();
        JobScheduler scheduler = new JobScheduler(store, 4, 500);

        scheduler.start();

        JobDetail job = new JobDetail.Builder()
                .name("print-hello")
                .description("Prints hello every 5 seconds")
                .trigger(new FixedDelayTrigger(Duration.ofSeconds(5)))
                .handler(() -> {
                    System.out.println("Hello from job at " + System.currentTimeMillis());
                    // Simulate work
                    Thread.sleep(1000);
                })
                .maxRetries(3)
                .build();

        String jobId = scheduler.scheduleJob(job);
        System.out.println("Scheduled job with id: " + jobId);

        // Let scheduler run for 25 seconds
        Thread.sleep(25000);
        scheduler.shutdown();
    }
}

