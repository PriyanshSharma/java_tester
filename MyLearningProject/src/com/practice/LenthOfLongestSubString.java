package com.practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LenthOfLongestSubString {

	static List<Integer> allSubSetsOfString = new ArrayList<Integer>();
	public static void main(String[] args) {
		
		String input = "abdefegabef";
		int start =0 ; 
		int end = input.length();
		String current = "";
		
		getAllSubStrings(input);
		System.out.println(allSubSetsOfString.stream().mapToInt(v->v).max().getAsInt());
	}

	private static void getAllSubStrings(String input) {
		
		for(int i = 0 ; i < input.length() ; i ++) {
			for (int j = i+1 ; j <= input.length() ; j++) {
				String s = input.substring(i,j);
				String [] strArr = s.split("");
				LinkedHashSet<String> setString = (LinkedHashSet<String>) Stream.of(strArr).collect(Collectors.toCollection(LinkedHashSet :: new));
				if(setString.size() == s.length()) {
					allSubSetsOfString.add(s.length());
				}
				
			}
		}
		
	}
}
