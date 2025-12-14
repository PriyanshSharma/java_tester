package com.practice.designpattern.StartegyDesignPattern.WithoutStrategy.Model;

public class RacingCar extends BaseModel implements BaseCar {


	public RacingCar(String carName, String carType) {
		super(carName, carType);

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
	public void fastEngineCapability() {

		System.out.println(" Speed Engine, max engine capacity -- 200kmph");
	}

	@Override
	public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}
}
