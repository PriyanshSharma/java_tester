package com.jobScheduler.entity;

import java.time.Duration;
import java.time.Instant;

public class FixedDelayTrigger implements JobTrigger {

	  private final Duration delay;

	    public FixedDelayTrigger(Duration delay) {
	        this.delay = delay;
	    }

	    @Override
	    public Instant getNextFireTime(Instant lastRunTime, Instant now) {
	        if (lastRunTime == null) {
	            return now.plus(delay);
	        }
	        return lastRunTime.plus(delay);
	    }

	    public Duration getDelay() {
	        return delay;
	    }
}
