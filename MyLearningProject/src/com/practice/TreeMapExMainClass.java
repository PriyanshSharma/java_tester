package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TreeMapExMainClass {

	public static void main(String[] args) {
		
//		ValueComparator myComparator = new ValueComparator();
//		TreeMap<Map.Entry<Employee, String>, String> valueSortMap= new TreeMap<Map.Entry<Employee,String>, String>(myComparator);
//		TreeMap<Employee,String> treeMap = new TreeMap<>();
//		
//		treeMap.put(new Employee("ABC",1), "ABC");
//		treeMap.put(new Employee("DEF",2), "DEF");
//		treeMap.put(new Employee("GHI",3), "GHI");
//		treeMap.put(new Employee("JKL",4), "JKL");
//		treeMap.put(new Employee("MNO",5), "MNO");
//		
//		
//		 List<Employee> list = new ArrayList<>();
//	        list.add(new Employee("ABC",1));
//	        list.add(new Employee("DEF",2));
//	        list.add(new Employee("GHI",3));
//	        list.add(new Employee("JKL",4));
//	        list.add(new Employee("MNO",5));
//		
//		List<Map.Entry<Employee, String>> list1 =  new ArrayList<Map.Entry<Employee,String>>(treeMap.entrySet());
//		Collections.sort(list1, myComparator);
////		List<Employee> stringLsit = new ArrayList<>();
////		stringLsit.stream().collect(Collectors.toMap(s-> s., valueMapper))
//		
//		Map<Employee,String> print = list1.stream().collect(Collectors.toMap(x -> x.getKey(),x->x.getValue()));
//		
////		 Map<Integer, String> result3 = list.stream().collect(
////	                Collectors.toMap(x -> x.getId(), x -> x.getName()));
////		Map<Integer, String> result3 =list.stream().collect(Collectors.toMap(x-> x.getId(),x.getName()));
//				
//		 
//		System.out.println(print);
//		
		List<String> l = new ArrayList<String>();
		l.add("dcf");
		l.add("JKL");
//		l.remove("ABC");
		l.add(0, "ABC");
		System.out.println(l);
		
	}
}
