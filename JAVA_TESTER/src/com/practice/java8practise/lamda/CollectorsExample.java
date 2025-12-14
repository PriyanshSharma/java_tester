package com.practice.java8practise.lamda;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.practice.POJO.Employee;

public class CollectorsExample<T,U> {

	public static void main(String[] args) {
		
		toCollectionExm(Employee.getEmployeeList());
		toMapExample(Employee.getEmployeeList());
		joiningExample();
		summarizingEx();
		groupingByExample();
		mappingExample();
	}
	
	public static void toCollectionExm(List<Employee> eList) {
	
		Supplier<LinkedList<String>> supp = ()->new LinkedList();
		eList.stream().map(emp->emp.getName()).peek(s->System.out.println("Providing external supplier")).
		collect(Collectors.toCollection(supp)).forEach(System.out::println);
		// equivalent -- 
		eList.stream().map(emp->emp.getName()).collect(Collectors.toCollection(()->new LinkedList<String>()));

		// constructor reference
		
		eList.stream().map(emp->emp.getName()).collect(Collectors.toCollection(LinkedList::new)).forEach(System.out::println);;

	}
	
	
	/*
	 * Used to create a Map
	 */
	public static void toMapExample(List<Employee> eList) {
		
		System.out.println("toMapExample..................");
		Map<String, Employee>mapPrinter =  eList.stream().collect(Collectors.toMap(e->e.getName(), ev->ev));
		mapPrinter.forEach((k,v)-> System.out.println(k+"="+v));
		//Handling duplicate keys -- 
		
		eList.addAll(eList);
		eList.forEach(System.out::println);
		mapPrinter = eList.stream().collect(Collectors.toMap(e->e.getName(), e->e,(e,e1)->e));
		
		/*
		 * Exception in thread "main" java.lang.IllegalStateException: Duplicate key
		 * Employee--101 (attempted merging values Employee [empId=202,
		 * name=Employee--101, salary=1212.0, departMent=DepartMent [deptId=3943,
		 * deptName=DEPT--3943]] and Employee [empId=202, name=Employee--101,
		 * salary=1212.0, departMent=DepartMent [deptId=3943, deptName=DEPT--3943]])
		 */
//		mapPrinter = eList.stream().collect(Collectors.toMap(e->e.getName(), e->e)); 

		
		System.out.println("New Map - ");
		mapPrinter.forEach((k,v)-> System.out.println(k+"="+v));
		
		// same map but sorting -- 
		mapPrinter = eList.stream().collect(Collectors.toMap(e->e.getName(), e->e,(e,e1)->e,TreeMap::new));
		System.out.println("Tree Map sorted..");
		mapPrinter.forEach((k,v)-> System.out.println(k+"="+v));
		
		//Use collecting and then - remaining


		

	}
	
	public static void joiningExample () {
		
		List<String> lsit = Arrays.asList("Priyansh","Sharma","Ruchi","Sristi");
		
		String ser = lsit.stream().collect(Collectors.joining(",","Prefix "," Suffix"));
		
		System.out.println(ser);
	}
	
	public static void summarizingEx() {
		List<Employee> eList = Employee.getEmployeeList();
		DoubleSummaryStatistics d =eList.stream().collect(Collectors.summarizingDouble(e->e.getSalary()));
		  System.out.println("Count: " + d.getCount());
	        System.out.println("Sum: " + d.getSum());
	        System.out.println("Min: " + d.getMin());
	        System.out.println("Max: " + d.getMax());
	        System.out.println("Average: " + d.getAverage());
	        
	     // same like summingDouble/Int/Long
	}
	public static void groupingByExample () {
		List<Employee> eList = Employee.getEmployeeList();
		eList.addAll(eList);

		Map<String,List<Employee>> sMap =  eList.stream().collect(Collectors.groupingBy(e->e.getName()));
		
		
		sMap.forEach((k,v)->System.out.println(k+" = "+v));
		
		Map<String,Long> mapperToCount = eList.stream().collect(Collectors.groupingBy(emp->emp.getName(),Collectors.counting()));
		mapperToCount.forEach(new CollectorsExample()::printerMe);
	}
	
	public  void printerMe(T k, U v) {
		
		System.out.println(k+" = "+v);
	}
	
	public static void mappingExample() {
		
		List<Employee> elist = Employee.getEmployeeList();
		
		
		elist.addAll(elist);
		List<String> nameList = elist.stream().collect(Collectors.mapping(e->e.getName(), Collectors.toList()));
		
		nameList.forEach(System.out::println);
		
		
		Map<Integer, List<Double>>mapperDouble = elist.stream().collect(Collectors.groupingBy(e->e.getEmpId(),Collectors.mapping(e1->e1.getSalary(), Collectors.toList())));
		System.out.println("Mapping example =");
		
		mapperDouble.forEach(new CollectorsExample()::printerMe);
	}
}
