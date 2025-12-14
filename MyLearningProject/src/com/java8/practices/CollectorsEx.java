package com.java8.practices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bt.dataLayer.EmployeeProvider;
import bt.models.Employee;

public class CollectorsEx {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("one","two","three","four");
		List<Employee> empList = EmployeeProvider.getEmployee();
		
		String s = "I am learnign java";
		
//		Map<char[], Long> map = 
				Stream.of(s.toCharArray()).
				
				collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		Map<String, List<Employee>> groupByMap=
				empList.stream().collect(Collectors.groupingBy((Employee x)->x.getFirstName(), Collectors.toList()));
		System.out.println(groupByMap);
//		empList.stream().map(mapper).collec
//		
//		
//		//Map.replaceAll ex
//		
		mapReplaceAllEx(groupByMap);
//		
//		
//		mapComputeEx similar to computeIfPresent()
//		
		mapComputeEx(groupByMap);
//		
//		// same with the case of computeIfAbsent, if Key is not present it will do some operation
//		//computeIfAbsentEx
//		
		mapComputeIfAbsentEx(groupByMap);
	}

	private static void mapComputeIfAbsentEx(Map<String, List<Employee>> groupByMap) {
			
		
		String key = "JAVA";
		
		//Adding new KEY in map with associated value
		groupByMap.computeIfAbsent(key, V-> {
			Employee e = new Employee("106", "JAVA", 89000.87, "JAVA 8", null);
			List<Employee> list = new ArrayList<>();
			list.add(e);
			return list;
		});
		
		groupByMap.computeIfAbsent("SPRING-BOOT", K-> Arrays.asList(new Employee("107", "Spring", 30000.00, "Boot", null)));
		
		System.out.println("Compute if absent..... ");
		System.out.println(groupByMap);
		
	}

	/*
	 * Similar to replace, but replaces only a specific key based entry
	 * Though if specified key is not there, use computeIfPresent
	 */
	private static void mapComputeEx(Map<String, List<Employee>> groupByMap) {
		String key = "Ruchi";
		groupByMap.compute(key, (k,v)-> {
			v.forEach(e->e.setSalary(40000.00));
			return v;
		});
		
		System.out.println("Compute ");
		System.out.println(groupByMap);
	}

	private static void mapReplaceAllEx(Map<String, List<Employee>> groupByMap) {

		BiFunction<Employee, List<Employee>, List<Employee>> biF = (e,l)->{
			e.setSalary(0);
			l.add(e);
			return l;
		};
		groupByMap.replaceAll((k,v)->v.stream().map((Employee e)->{
			e.setSalary(0);
			return e;
		}).collect(Collectors.toList()));
		System.out.println(groupByMap);
	
	}
}
