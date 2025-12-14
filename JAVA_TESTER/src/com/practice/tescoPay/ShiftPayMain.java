package com.practice.tescoPay;

import java.util.ArrayList;
import java.util.List;

public class ShiftPayMain {

	
	
	public static void main(String[] args) {
		Employee emp  = populateEmployeeInput();
		
		PayCalculatorServiceClass payService = new PayCalculatorServiceClass();
		double totalPay = payService.getTotalPayForEmployee(emp);
		
		System.out.println("Total Pay = "+totalPay);
	}
	
	
	public static Employee populateEmployeeInput() {
		Employee emp = new Employee("101");
		
		ShiftsWorked shift1 = new ShiftsWorked("S1");
		
		List<ShiftsWorked> shifts = new ArrayList<ShiftsWorked>();
		
		shift1.setBreakDuration(0.0d);
		shift1.setTotalDuration(5.0d);
		shift1.setSkill("Bakery");
		
		shifts.add(shift1);
		
		emp.setEmployeeShiftsList(shifts);
		emp.setContractType("Permanent");
		
		return emp;
		
	}
}
