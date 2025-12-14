package com.practice.designpattern.StartegyDesignPattern.WithoutStrategy.Model;

public class LuxuryCar extends BaseModel implements BaseCar {

	public LuxuryCar(String carName, String carType) {
		super(carName, carType);
	}

	@Override
	public void driveCapability() {
		
		System.out.println(" Luxury drive with most features..");
	}

	@Override
	public void luxuryCapability() {

		System.out.println(" luxury rating 10/10");
	}

	@Override
	public void fastEngineCapability() {

		System.out.println(" Fast engine max speed - 200 kmph.");
	}

}
