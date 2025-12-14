package com.jobScheduler.entity;

import java.time.Instant;

public interface JobTrigger {
    Instant getNextFireTime(Instant lastRunTime, Instant now);
}
