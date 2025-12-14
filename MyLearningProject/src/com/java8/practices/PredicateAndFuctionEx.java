package com.java8.practices;

import java.util.function.Function;
import java.util.function.Predicate;

import bt.models.Employee;

public class PredicateAndFuctionEx {

	public static void main(String[] args) {
		
		Employee[] e = {
//				new Employee("1", "ABC", 10000d),
//				new Employee("2", "DEF", 20000d),
//				new Employee("3", "XYX", 30000d),
////				new Employee("4", "GHI", 40000d),
//				new Employee("5", "JKL", 50000d),
//				
				
		};
		
		Function <Employee, String> f= emp-> {
			
			if(emp.getSalary()>=40000)
				return "Class 1 EMp" ;
			else if(emp.getSalary()<40000 && emp.getSalary()>=30000)
				return "Class 2 emp";
			else 
				return "Same class emp";
		};
		
		
		Predicate<Employee> salPredicate = sal->sal.getSalary()>20000;
		
		
		for(Employee err : e) {
			
			if(salPredicate.test(err)) {
				System.out.println(f.apply(err));
			}
			
		}
		
		
		
	}
}
