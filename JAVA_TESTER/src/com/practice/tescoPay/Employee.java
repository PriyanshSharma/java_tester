package com.practice.tescoPay;

import java.util.List;

public class Employee extends BaseEntity {
	
	
	public Employee(String Uid) {
		super(Uid);
	}

	private List<ShiftsWorked> employeeShiftsList;
	
	private String contractType ;

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public List<ShiftsWorked> getEmployeeShiftsList() {
		return employeeShiftsList;
	}

	public void setEmployeeShiftsList(List<ShiftsWorked> employeeShiftsList) {
		this.employeeShiftsList = employeeShiftsList;
	}
	
	
}
