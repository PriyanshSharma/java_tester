package com.practice.java8practise.lamda;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapMergeExamplw {

	public static void main(String[] args) {
		Map<String,Integer> myMap  = new LinkedHashMap<String, Integer>();
		myMap.put("Apple", 111);
		myMap.put("Banana", 209);
		myMap.put("cake", 487);
		myMap.put("Chilli", 10);
		myMap.put("Onion", 109);
		myMap.put("Grape", 100);
		
		Map<String,Integer> myMap1  = new LinkedHashMap<String, Integer>();
		myMap1.put("Apple", 100);
		myMap1.put("Potato", 209);
		myMap1.put("cake", 200);
		myMap1.put("Guava", 10);
		myMap1.put("Anar", 109);
		myMap1.put("Grape", 10);
		
		myMap.forEach((k,v)-> myMap1.merge(k, 1000, (v1,v2)-> {
			System.out.println("K = "+k);
			System.out.println("V1 value -- "+v1);
			System.out.println("V2 value -- "+v2);
			System.out.println("V value -- "+v);
			
			return v1+v2;

		}));
		myMap1.forEach((k,v)-> System.out.println(k+" = "+v));
		
	
		
	}
}
