package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class RibbonEx {
public static void main(String[] args) {
	
	List<String> inputList = Arrays.asList("cat","act","dog","goat","eat","ate","god");
	List<String> equatedLsit = new ArrayList<String>();
	List<List<String>> groupedList = new ArrayList<List<String>>();
	for(String s : inputList) {
		
		char[] charArr = s.toCharArray();
		Arrays.sort(charArr);
		String combine = new String(charArr);
		
		equatedLsit.add(combine);
	}
	
	// {act,act,dgo,goat,aet,aet,dgo}
	Map<String,List<String>> mappedAngrams = new HashMap<>();
	for(int i = 0;i<equatedLsit.size();i++) {
		List<String> valList = null;
		if(!mappedAngrams.containsKey(equatedLsit.get(i))) {
			valList = new ArrayList<String>();
			valList.add(inputList.get(i));
			mappedAngrams.put(equatedLsit.get(i),valList);
		}else {
			valList =  mappedAngrams.get(equatedLsit.get(i));
			valList.add(inputList.get(i));
				
			}
		}
		
	List<List<String>> resultant = new ArrayList<List<String>>();
		for(Entry<String, List<String>> e : mappedAngrams.entrySet()) {
			resultant.add(e.getValue());
		}
		resultant.forEach(l->l.forEach(System.out::println));
	}

	
	}
