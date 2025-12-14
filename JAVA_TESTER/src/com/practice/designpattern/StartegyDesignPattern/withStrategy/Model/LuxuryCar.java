package com.practice.designpattern.StartegyDesignPattern.withStrategy.Model;

import com.practice.designpattern.StartegyDesignPattern.withStrategy.strategies.IEngineStrategy;

public class LuxuryCar extends BaseModel implements BaseCar {

	public LuxuryCar(String carName, String carType, IEngineStrategy strategy) {
		super(carName, carType, strategy);
	}

	@Override
	public void driveCapability() {
		
		System.out.println(" Luxury drive with most features..");
	}

	@Override
	public void luxuryCapability() {

		System.out.println(" luxury rating 10/10");
	}


}
