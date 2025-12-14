package com.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppviewxEx {

	public static void main(String[] args) {
		String s = "hello world";

		TreeMap<String, List<Integer>> tree = new TreeMap<>();

		for (int i = 0; i < s.length(); i++) {
			String key = s.charAt(i) + "";
			if (tree.containsKey(key)) {
				tree.get(key).add(i);
			} else {
				List<Integer> l = new ArrayList<>();
				l.add(i);
				tree.put(key, l);
			}
		}

		// for(Map.Entry<String, List<Integer>> e:tree.entrySet() ) {
		// System.out.println(e.getKey()+" = "+e.getValue());
		// }

		Stream.of(s.split("")).collect
		(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().forEach(System.out::println);
		tree.entrySet().forEach(System.out::println);

	}
}
/*
 * 
 * select max(sal) from employee where sal < (select max(sal) from employee);
 * 
 * 
 * 
 */
