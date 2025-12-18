package com.practice.atlassianDesignCode.service;

import com.practice.atlassianDesignCode.Model.Driver;
import com.practice.atlassianDesignCode.Model.Lap;

public class LastHeroCalculator {

	public static double calculateAvgTillSecondLastLap(Driver d) {
		
		double avgTime=0.00d;
		double totalSum = 0.00d;
		for (int i = 0 ; i < d.getDriversLap().size() ; i++) {
			
			totalSum += d.getDriversLap().get(i).getLapDuration();
			
		}
		
		avgTime = totalSum/(d.getDriversLap().size());
		
		return avgTime;
	}
	
	
	
	
	
	
	
	
}
