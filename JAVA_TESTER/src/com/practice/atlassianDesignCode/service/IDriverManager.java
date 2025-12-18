package com.practice.atlassianDesignCode.service;

import com.practice.atlassianDesignCode.Model.Driver;
import com.practice.atlassianDesignCode.Model.Lap;

public interface IDriverManager {

	public void addDriverLap(Driver d, Lap lap);
	
	public Driver getLastLapHero();
	
}
