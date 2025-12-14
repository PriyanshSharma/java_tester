package com.java8.practices;

import java.util.function.Consumer;

import bt.models.Employee;

public class ConsumerEx {
public static void main(String[] args) {
	Consumer<Employee> consumer = emp-> {
		System.out.println("Name -- "+emp.getFirstName()+" "+emp.getLastName());
		System.out.println("ID - "+emp.getId());
		System.out.println("Salary -- "+emp.getSalary());
		
	};
	
	
	Employee[] earr = {
			
			
			
	};
	
	for(Employee e : earr) {
		consumer.accept(e);
	}
}
}
