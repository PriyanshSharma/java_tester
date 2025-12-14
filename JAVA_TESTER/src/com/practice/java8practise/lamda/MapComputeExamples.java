package com.practice.java8practise.lamda;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapComputeExamples {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Priyansh", "Sharma");
		map.put("Ruchi", "trivedi");
		
		//Old Java way -- 
		
		for (Entry<String, String> m : map.entrySet()) {
			String k = m.getKey();
			String v = m.getValue();
			
			if("Ruchi".equalsIgnoreCase(k)) {
				v=v+" Sharma";
				map.put(k, v);
			}
		}
		
		map.forEach((k,v)->System.out.println(k+" = "+v));
		
		// JAva 8 way
		
		map.compute("Ruchi", (k,v)-> v.contains("Sharma")?v:v+" Sharma");
		System.out.println("After..");
		map.forEach((k,v)->System.out.println(k+" = "+v));

		map.computeIfPresent("Ruchi1", (k,v)-> v.contains("Sharma")?v:v+" Sharma");
		System.out.println("After..");
		map.forEach((k,v)->System.out.println(k+" = "+v));
		

		map.computeIfAbsent("Ruchi1", s->{
			return " Sharma";
		});
		System.out.println("After..");
		map.forEach((k,v)->System.out.println(k+" = "+v));
		

		String s = "apple banana apple anar banana grape";
		Map<String, Integer> counter = new HashMap<String, Integer>();
		
		
		//Old java way
		
		for (String s1:s.split(" ")) {
			
			if(counter.containsKey(s1)) {
				int newval = counter.get(s1)+1;
				counter.put(s1, newval);
			}else {
				counter.put(s1, 1);
			}
		}
		
		// Java 8 way
//		for (String s1:s.split(" ")) {
//			counter.merge(s1, 1, (v1,v2)->v1+v2);
//		}
		System.out.println("String merger");
		counter.forEach((k,v)-> System.out.println(k+" = "+v));
	}
	Runnable fr = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	};
}
