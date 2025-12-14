package com.practice.java8practise.lamda;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.practice.POJO.Employee;

public class GroupingemployeeExample {

	public static void main(String[] args) {
		List<Employee> empList = Employee.getEmployeeList();
		List<Employee> emplist2 = Employee.getEmployeeList();
		emplist2.addAll(empList);
		groupByDepartMent(emplist2);
	}
	
	public static void groupByDepartMent(List<Employee> empList) {
		
		Map<String,List<Employee>> deptToEmpMap = empList.stream().collect(Collectors.groupingBy(emp->emp.getDepartMent().getDeptName(), Collectors.toList()));
		
		deptToEmpMap.forEach((k,v)-> System.out.println(k+" = "+v));
		
		// Collect only empid
		
		empList.stream().collect(Collectors.groupingBy(emp->emp.getDepartMent().getDeptName(), 
				Collectors.mapping(e1->e1.getEmpId(), Collectors.toList()))).forEach((k,v)-> System.out.println(k+" = "+v));;
		

	}
}
