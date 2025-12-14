package com.practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class USTGlbalEx {
public static void main(String[] args) {
//	Scanner s = new Sc
	String s = "Applesadsdfsdfadsadfsdfsdfsdfsdf";
	List<String> l;
	
//	l.stream().map
	if(s.length()<=256) {
		Map<String,Long> map =
		Stream.of(s.split("")).map(String::toLowerCase).
		collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));	
		
		
		Map<Character,Long> mapper = new HashMap<Character, Long>();
		for(Character c : s.toCharArray()) {
			if(map.containsKey(c)) {
				long l1 = mapper.get(c);
				l1++;
				mapper.put(c, l1);
			}
			else {
				
			}
		}
	}
	/*
	 * select min(e.sal) from Employee e, department d, group by d.did having d.location='bangalroe'
	 * 
	 * select count(*) from department where localtion not in ('bangalore')
	 */
	
}
}
