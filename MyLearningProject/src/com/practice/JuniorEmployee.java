package com.practice;

public class JuniorEmployee extends Employee {

	
	String juniorName;
	
	public String getJuniorName() {
		return juniorName;
	}

	public void setJuniorName(String juniorName) {
		this.juniorName = juniorName;
	}

	public JuniorEmployee(String name, int id) {
		super(name, id);
	}

}
