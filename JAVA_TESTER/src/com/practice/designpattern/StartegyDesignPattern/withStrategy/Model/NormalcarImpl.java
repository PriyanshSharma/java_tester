package com.practice.designpattern.StartegyDesignPattern.withStrategy.Model;

import com.practice.designpattern.StartegyDesignPattern.withStrategy.strategies.IEngineStrategy;

public class NormalcarImpl extends BaseModel implements BaseCar {

	
	
	public NormalcarImpl(String name, String type, IEngineStrategy strategy) {
		super(name, type, strategy);
		
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
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
