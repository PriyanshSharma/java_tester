package com.java8.practices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReduceFunctionEx {
public static void main(String[] args) {
	List<String> al = new ArrayList<String>();
	
	al.add("Geeks");al.add("for");al.add("geeks");
	
	String com = al.stream().reduce("ABC",(w1,w2)->w1+w2);
//	Collectors.reducing(op)
	System.out.println(com);
}
}
