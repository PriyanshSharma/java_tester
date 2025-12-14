package com.practice;

import java.util.HashMap;
import java.util.Map;

import com.practice.POJO.Employee;

public class EmployeeHashCodeAndEqualsCheck {

	public static void main(String[] args) {
		Employee e9 = null;
		Map<Employee, Employee> mapEmp = new HashMap<Employee, Employee>();
		
		for (int i = 0 ; i <10; i ++) {
			Employee e = new Employee(i, "Employee--"+i);
			mapEmp.put(e, e);
			if (i == 9 ) {
				e9 = new Employee(i, "Employee--"+i);
				mapEmp.put(e9, e9);
			}
		}
		
		System.out.println("Current Size ="+mapEmp.size());
		System.out.println(mapEmp.get(e9).toString());
		
	}
}
