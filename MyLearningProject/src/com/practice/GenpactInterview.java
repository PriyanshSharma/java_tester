package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenpactInterview {
public static void main(String[] args) {
	
	List<Integer> list = Arrays.asList(1,1,2,2,2,3,4,5,7,7);
	String s = "faf";
	
	Map<Integer, Long> mapper =
	list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	
	
//	mapper.entrySet().forEach(entry-> entry.getValue()>1 ?System.out.println(entry.getKey()+"="+entry.getValue()):System.out.println(""));
}
}
