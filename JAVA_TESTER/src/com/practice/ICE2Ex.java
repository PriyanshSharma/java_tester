package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.practice.POJO.Employee;

public class ICE2Ex {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		
		empList = empList.stream().filter(e->e.getSalary()>50000).collect(Collectors.toList());
		List<String> nameLsit  = empList.stream().filter(e->e.getSalary()>50000).map(e->e.getName()).collect(Collectors.toList());
		
		// Name - fname Lname
		
		empList.stream().filter(e->e.getSalary()>50000).map(e->e.getName().split(" ")[1]).collect(Collectors.toList());
		

	}
}
