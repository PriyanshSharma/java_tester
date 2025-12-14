package com.jobScheduler.entity;

@FunctionalInterface
public interface JobHandler {
    void execute() throws Exception;
}
