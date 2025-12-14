package com.practice.designpattern.StartegyDesignPattern.WithoutStrategy.Model;

public class NormalcarImpl extends BaseModel implements BaseCar {

	
	
	public NormalcarImpl(String name, String type) {
		
		super(name,type);
		
		
	}
	
	@Override
	public void driveCapability() {
		
		
		System.out.println("Driving capability is normal");

	}

	@Override
	public void luxuryCapability() {

		System.out.println(" Normal car with basic feature, no luxury");
	}

	@Override
	public void fastEngineCapability() {

		System.out.println("normal engine - max speed 80kmph");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
