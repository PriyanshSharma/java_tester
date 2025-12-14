package com.practice.designpattern.StartegyDesignPattern.withStrategy.Model;

import java.util.UUID;

import com.practice.designpattern.StartegyDesignPattern.withStrategy.strategies.IEngineStrategy;

public abstract class BaseModel implements BaseCar {

	private String id;
	private String carName ;
	private String carType;
	private IEngineStrategy engineStrategy;
	
	/*
	 * If I want to have more strategy like pay for the card with several strategies like pay via card, UPI, banktransfer, then
	 * in the same I need to create a seperate IPayStrategy and then extend concrete class like UPIStrategy, BankStrategy and all
	 * and in this class pay method jsut call those classes Object in the same way of doing like constructor injection.
	 */
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public BaseModel(String carName, String carType, IEngineStrategy strategy) {
		super();
		
		this.id = UUID.randomUUID().toString();
		this.carName = carName;
		this.carType = carType;
		this.engineStrategy = strategy;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", carName=" + carName + ", carType=" + carType + "]";
	}
	
	
	@Override
	public void fastEngineCapability() {

		engineStrategy.fastEngineStrategy();
	}

	
}
