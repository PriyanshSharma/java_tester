package com.practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountWords {

	public static void main(String[] args) {
		String para = "My name is Priyansh, your, name is Koushik.";
		
		String[] arr = para.split(" ");
		
		
		
		Map<String, List<String>> map = new HashMap<>();
//		map =Stream.of(arr).collect(Collectors.toMap(x->x.toString(), v->(Integer)(v+1)));
		
		map =Stream.of(arr).collect(Collectors.groupingBy(x->x,Collectors.toList()));
//		for(String a:arr) {
//			if(map.get(a)!=null) {
//				int v = map.get(a);
//				map.put(a, v+1);
//						
//			}else {
//				map.put(a, 1);
//			}
//		}
		
		map.entrySet().forEach(k-> System.out.println(k.getKey()+" "+k.getValue()));
	}
}
