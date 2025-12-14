package com.jobScheduler.entity;

import java.util.List;
import java.util.Optional;

public interface JobStore {

	   void saveJob(JobDetail job);
	    Optional<JobDetail> getJob(String jobId);
	    List<JobDetail> getAllJobs();
	    void updateJob(JobDetail job);
	    void deleteJob(String jobId);
}
