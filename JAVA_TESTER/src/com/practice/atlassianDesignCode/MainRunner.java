package com.practice.atlassianDesignCode;

import java.util.HashMap;

import com.practice.atlassianDesignCode.Model.Driver;
import com.practice.atlassianDesignCode.Model.Lap;
import com.practice.atlassianDesignCode.service.DriveManagerImpl;
import com.practice.atlassianDesignCode.service.IDriverManager;

/**
 * Accepts lap time for Drivers= given for each driver
 * 
 * return the last lap hero.
 * Last lap hero = Biggest improvement in their previous last Lap.
 * 
 * 
 * 1. Lap might not be equal.
 * 2. laptime=Driver (input).
 * 3. 
 * 
 * 
 * Duration - 100 - sec, d1=100,d2=200
 * 
 * D1->100,200,99, --> 96-95
 * D2->200,100,99, --> 100-- 98 => Correct Assumption
 * 
 * 
 * 
 * Model --> 
 * Driver-driverid,List<lAP>, Lap --> lapnumber, lapDuration
 * 1:M
 * Driver has a List<Lap>
 * 
 * Services
 * interface IDriverManager {
 *  	-addDriversLap(Driver d);
 *  	-getLastLapHero();
 * 
 * }
 * 
 * DriverManager has a Driver ==>
 * 
 * tescase - 
 * 
 * Driver, Lap Time

"Driver1", 100

"Driver2", 90

"Driver3", 70

"Driver1", 110

"Driver2", 95

"Driver3", 50

// Driver 1 Last Lap Gain = 110 - (100+110)/2 = 5 ==>

// Driver 2 Last Lap Gain = 95 - (90+95)/2 = 2.5

// Driver 3 Last Lap Gain = 50 - (70+50)/2 = -10

// Driver 3 is last lap hero
 */
public class MainRunner {

	public static void main(String[] args) {
		
		IDriverManager drvServc = new DriveManagerImpl();
		
		
		drvServc.addDriverLap(new Driver("Driver1"), new Lap(1, 100));
		drvServc.addDriverLap(new Driver("Driver2"), new Lap(1, 90));
		drvServc.addDriverLap(new Driver("Driver3"), new Lap(1, 70));
		drvServc.addDriverLap(new Driver("Driver1"), new Lap(2, 110));
		drvServc.addDriverLap(new Driver("Driver2"), new Lap(2, 95));
		drvServc.addDriverLap(new Driver("Driver3"), new Lap(2, 50));
		
		
		Driver ans = drvServc.getLastLapHero();
		System.out.println(ans.getDriverId());
		
		
		
		
	}
}
