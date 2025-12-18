package com.practice.atlassianDesignCode.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.practice.atlassianDesignCode.Model.Driver;
import com.practice.atlassianDesignCode.Model.Lap;

public class DriveManagerImpl implements IDriverManager {

	private Map<String,Driver> driverList ;
	
	@Override
	public void addDriverLap(Driver d, Lap lap) {

		// If driver is already existing - Add the newly Lap to the existing Driver's Lap list
		if (driverList.containsKey(d.getDriverId())) {
			List<Lap> driverLap =  driverList.get(d.getDriverId()).getDriversLap();
			driverLap.add(lap);
		}
		
		
		// If Driver's first Lap create a Driver with a List of Lap having only one entry.
		else {
			List<Lap> driverLap = new ArrayList<Lap>();
			driverLap.add(lap);
			d.setDriversLap(driverLap);
			driverList.put(d.getDriverId(), d);
		}

	}

	@Override
	public Driver getLastLapHero() {
		
		
		double maxi = Double.MIN_VALUE;
		Driver lastLaphero = null;
		for (Map.Entry<String, Driver> entry : driverList.entrySet()) {
			
			
			List<Lap> driverLap = entry.getValue().getDriversLap();
			Driver driver = entry.getValue();
			double avgTillSecondLastLap = LastHeroCalculator.calculateAvgTillSecondLastLap(driver);
			
			double diffBetweenLastandAvg = avgTillSecondLastLap - driverLap.get(driverLap.size()-1).getLapDuration();
			
			if (diffBetweenLastandAvg>maxi) {
				lastLaphero = driver;
				maxi=diffBetweenLastandAvg;
				
			}
		}
		
		
		return lastLaphero;
	}

	public DriveManagerImpl() {
		super();
		this.driverList = new HashMap<String, Driver>();
	}

}
