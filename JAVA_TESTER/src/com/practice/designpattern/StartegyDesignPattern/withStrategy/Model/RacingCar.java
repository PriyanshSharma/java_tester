package com.practice.designpattern.StartegyDesignPattern.withStrategy.Model;

import com.practice.designpattern.StartegyDesignPattern.withStrategy.strategies.IEngineStrategy;

public class RacingCar extends BaseModel implements BaseCar {


	public RacingCar(String carName, String carType, IEngineStrategy strategy) {
		super(carName, carType, strategy);

	}

	@Override
	public void driveCapability() {

		System.out.println("Racing car capabilities..");
	}

	@Override
	public void luxuryCapability() {

		System.out.println(" No luxury , racing car on the wheelss");
	}

	
	@Override
	public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}
}
