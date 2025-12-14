package com.practice.designpattern.StartegyDesignPattern.WithoutStrategy.Model;

import java.util.UUID;

public class BaseModel {

	private String id;
	private String carName ;
	private String carType;
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
	public BaseModel(String carName, String carType) {
		super();
		
		this.id = UUID.randomUUID().toString();
		this.carName = carName;
		this.carType = carType;
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
	
	
	
	
}
