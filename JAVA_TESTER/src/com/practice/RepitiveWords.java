package com.practice;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepitiveWords {

	public static void main(String[] args) {
		String s = "Hello world Hello ksjfks Hello priyansh priyansh";
		String sArr[] = s.split(" ");
		List<String> lsit = Arrays.asList(sArr);
		
		Map<String, Long> map = lsit.stream().collect(Collectors.groupingBy(s1->s1,Collectors.counting()));
		
		map = map.entrySet().stream().sorted((e1,e2)->e2.getValue().compareTo(e1.getValue())).
		collect(Collectors.toMap(e1->e1.getKey(), e1->e1.getValue(), (e1,e2)->e1,LinkedHashMap::new));
		
		
		map.forEach((k,v)-> System.out.println(k+"="+v));
		
	}
}
