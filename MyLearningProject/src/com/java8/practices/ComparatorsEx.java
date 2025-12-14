package com.java8.practices;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import bt.dataLayer.EmployeeProvider;
import bt.models.Employee;

public class ComparatorsEx {

	public static void main(String[] args) {
	List<Employee> empList = EmployeeProvider.getEmployee();
	Collections.synchronizedList(empList);
	sortByFname(empList);
	sortByFnameAndLastName(empList);
	
	AtomicInteger inte = new AtomicInteger(10);
			
	
	System.out.println("After sorting Employee original list ------- ");
	sortEmployyeOriginalList(empList);
	empList.forEach(System.out::println);
	
	
}
	
	private static void sortEmployyeOriginalList(List<Employee> empList) {
		
		System.out.println("Sorting by using list.sort() --------");
		empList.sort(Comparator.comparing((Employee e)->e.getFirstName()).thenComparing((Employee e)-> e.getLastName()));
		
	}

	public static void sortByFname(List<Employee> empList) {
		System.out.println("Sort by First Name using stream.sorted() -----");
		empList.stream().sorted((o1,o2)-> o1.getFirstName().compareTo(o2.getFirstName())).collect(Collectors.toList()).forEach(System.out::println);
	}
	
		public static void sortByFnameAndLastName(List<Employee> empList) {
		
	
	System.out.println("Sort By First name and Last Name using stream.sorted() ----");
		empList.stream().sorted(Comparator.comparing((Employee e)->e.getFirstName())
								.thenComparing((Employee e)->e.getLastName())).collect(Collectors.toList()).forEach(System.out::println);;
	
//		empList.sort(Comparator.comparing((Employee e)->e.getFirstName()).thenComparing(e->e.getLastName()));

}
	
}
