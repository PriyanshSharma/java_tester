package com.practice;

import java.util.ArrayList;
import java.util.List;

public class PracticeDriverClass {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Employee e1 = new Employee("ABC", 1);
		
		Employee clonedObecjt =   e1.clone();
		JuniorEmployee jEmp = new JuniorEmployee("ABC", 12);
		jEmp.clone();
		
		Object o = new Object();
		List<Employee> eList= new ArrayList<Employee>();
		
		System.out.println(clonedObecjt!=e1);
		System.out.println(e1.equals(clonedObecjt));
		System.out.println(e1.getClass()==clonedObecjt.getClass());
		
		
		System.out.println("Orignal === "+e1);
		
		System.out.println("Clonedd --- "+clonedObecjt);
		
		clonedObecjt.setName("DEF");
		
		System.out.println("After -----");
		
		
		System.out.println("Orignal === "+e1);
		
		System.out.println("Clonedd --- "+clonedObecjt);
		
	}
}
