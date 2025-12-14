package com.java8.practices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Java8SortedEx {
public static void main(String[] args) {
	List<Integer> al = new ArrayList<>();
	
	al.add(10);
	al.add(20);
	al.add(30);
	al.add(25);
	al.add(70);
	al.add(75);
	al.add(65);
	al.add(55);
	al.add(40);
	List<Integer> sortedList = new ArrayList<Integer>();
	
	// Below all three produce same result. Natural sorting order
	sortedList = al.stream().sorted((i1,i2)->-i1.compareTo(i2)).collect(Collectors.toList());
	sortedList = al.stream().sorted((i1,i2)->i1.compareTo(i2)).collect(Collectors.toList());
	sortedList = al.stream().sorted().collect(Collectors.toList());
	

	System.out.println("Natural sorting order -- "+sortedList);
	
	// Comparator sorting --- (i1,i2)-> (i1>i2)?1:(i1<i2)?-1:0 ===> same as compare method of Comparator
	
	sortedList = al.stream().sorted((i1,i2)-> (i1>i2)?1:(i1<i2)?-1:0).collect(Collectors.toList());
	System.out.println("Comparatr sorting order "+sortedList);
	
	sortedList = al.stream().sorted((i1,i2)-> (i1>i2)?-1:(i1<i2)?1:0).collect(Collectors.toList());
	System.out.println("Comparatr sorting order reverse order "+sortedList);
	
}
}
