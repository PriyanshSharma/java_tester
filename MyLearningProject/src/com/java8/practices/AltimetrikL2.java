package com.java8.practices;


import java.util.*;
import java.util.stream.Collectors;
public class AltimetrikL2 {
public static void main(String[] args) {
	List<Integer> l = new ArrayList<Integer>();
//	 [2, 10,5, 14,51
	l.add(2);
	 l.add(10);
	 l.add(5);
	 l.add(14);
	 l.add(51);
	 
	l.stream().map((val)-> String.valueOf(val)).filter(s1->s1.startsWith("5")).collect(Collectors.toList()).forEach(System.out::println);
}
}

