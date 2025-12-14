package com.practice.java8practise.lamda;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.practice.POJO.Employee;

public class StreamStateFulandStatelessOperation {

	public static void main(String[] args) {
//		statelessOperation(Employee.getEmployeeList());
		stateFull(Employee.getEmployeeList());
	}
	
	public static void statelessOperation (List<Employee> list) {
		// fileter the emp whose salary is less than x and increment the salry and print salary and name.
		list.stream().filter(e->{
			System.out.println("Filtering . . ."+e);
			return e.getSalary()<1500	;
		}).map(e->{
			System.out.println("Mapping.. "+e);
			String str=e.getName()+" - Salary increased= "+e.getSalary();
			return str;
		}).collect(Collectors.toList()).forEach(System.out::println);
	}
	public static void stateFull(List<Employee> list ) {
		list.stream().filter(e->{
			System.out.println("Filtering . . ."+e);
			return e.getSalary()<1500	;
		}).sorted((i1,i2)-> {
			System.out.println("Sorting....");
			Double result = i1.getSalary()-i2.getSalary();
			return result.intValue();
		})
		.map(e->{
			System.out.println("Mapping.. "+e);
			String str=e.getName()+" - Salary increased= "+(e.getSalary()+1000);
			return str;
		})
		.collect(Collectors.toList()).forEach(System.out::println);
		
	}
}
