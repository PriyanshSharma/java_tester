package com.practice.tescoPay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PayCalculatorServiceClass {

	
	
	public Map<String,Double> skilPayMapper = new HashMap<String, Double>();
	
	public Map<String,Double> contractPayMapper = new HashMap<String, Double>();
	
	/*
	 * generate the map for the skill-pay
	 */
	public PayCalculatorServiceClass() {
		
		skilPayMapper.put("Bakery", 2.0);
		skilPayMapper.put("Checkout Cashier", 1.2);
		skilPayMapper.put("Customer Service", 1.3);
		skilPayMapper.put("Shift Leader", 3.0);
		skilPayMapper.put("Security", 1.0);
		
		
		contractPayMapper.put("Permanent", 12.5d);
	}
	
	
	
	public Double getTotalPayForEmployee(Employee emp) {
		
		
		return getSkillSetPayments(emp) + getContractTypePaymentForEmp(emp);
	}
	
	
	
	private  double getSkillSetPayments(Employee emp) {
		
		List<ShiftsWorked> shiftList = emp.getEmployeeShiftsList();
		
		double result = 0.0d;
		
		for (ShiftsWorked s : shiftList) {
			
			double actualWorkedDuration = s.getTotalDuration() - s.getBreakDuration();
			
			double unitPriceForSkill = skilPayMapper.containsKey(s.getSkill())?skilPayMapper.get(s.getSkill()):0;
			
			double finalPrice = unitPriceForSkill*actualWorkedDuration;
			
			result += finalPrice;
			
		}
		return result;
		
	}
	
	
	private double getContractTypePaymentForEmp(Employee emp) {
		
		String contString  = emp.getContractType();
		
		double result = 0.0d;
		if (contString!=null && !contString.equals("")) {
			double contractPayPrice = contractPayMapper.containsKey(contString)?contractPayMapper.get(contString):0.0d;
			result += contractPayPrice;
		}
		return result;
	}
}
