package com.jobScheduler.entity;



import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class JobDetail {

    private final String jobId;
    private final String name;
    private final String description;
    private final JobTrigger trigger;
    private final JobHandler handler;

    private volatile JobStatusEnum status;
    private volatile Instant nextRunTime;
    private volatile Instant lastRunTime;
    private final int maxRetries;
    private volatile int currentRetryCount;

    private JobDetail(Builder builder) {
        this.jobId = builder.jobId != null ? builder.jobId : UUID.randomUUID().toString();
        this.name = builder.name;
        this.description = builder.description;
        this.trigger = Objects.requireNonNull(builder.trigger, "trigger is required");
        this.handler = Objects.requireNonNull(builder.handler, "handler is required");
        this.status = JobStatusEnum.SCHEDULED;
        this.nextRunTime = builder.initialNextRunTime;
        this.maxRetries = builder.maxRetries;
        this.currentRetryCount = 0;
    }

    public String getJobId() {
        return jobId;
    }

    public String getName() {
        return name;
    }

    public JobTrigger getTrigger() {
        return trigger;
    }

    public JobHandler getHandler() {
        return handler;
    }

    public JobStatusEnum getStatus() {
        return status;
    }

    public void setStatus(JobStatusEnum status) {
        this.status = status;
    }

    public Instant getNextRunTime() {
        return nextRunTime;
    }

    public void setNextRunTime(Instant nextRunTime) {
        this.nextRunTime = nextRunTime;
    }

    public Instant getLastRunTime() {
        return lastRunTime;
    }

    public void setLastRunTime(Instant lastRunTime) {
        this.lastRunTime = lastRunTime;
    }

    public String getDescription() {
        return description;
    }

    public int getMaxRetries() {
        return maxRetries;
    }

    public int getCurrentRetryCount() {
        return currentRetryCount;
    }

    public void incrementRetryCount() {
        this.currentRetryCount++;
    }

    public void resetRetryCount() {
        this.currentRetryCount = 0;
    }

    public static class Builder {
        private String jobId;
        private String name;
        private String description;
        private JobTrigger trigger;
        private JobHandler handler;
        private Instant initialNextRunTime;
        private int maxRetries = 0;

        public Builder jobId(String jobId) {
            this.jobId = jobId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder trigger(JobTrigger trigger) {
            this.trigger = trigger;
            return this;
        }

        public Builder handler(JobHandler handler) {
            this.handler = handler;
            return this;
        }

        public Builder initialNextRunTime(Instant nextRunTime) {
            this.initialNextRunTime = nextRunTime;
            return this;
        }

        public Builder maxRetries(int maxRetries) {
            this.maxRetries = maxRetries;
            return this;
        }

        public JobDetail build() {
            return new JobDetail(this);
        }
    }
}
