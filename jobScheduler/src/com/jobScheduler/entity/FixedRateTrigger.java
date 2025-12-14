package com.jobScheduler.entity;

import java.time.Duration;
import java.time.Instant;

public class FixedRateTrigger implements JobTrigger {
	 private final Duration period;

	    public FixedRateTrigger(Duration period) {
	        this.period = period;
	    }

	    @Override
	    public Instant getNextFireTime(Instant lastRunTime, Instant now) {
	        if (lastRunTime == null) {
	            return now.plus(period);
	        }
	        return lastRunTime.plus(period);
	    }

	    public Duration getPeriod() {
	        return period;
	    }

}
