package com.practice.DS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings strings, group the anagrams together. 
 * You can return the answer in any order.
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
	Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		
		
		String [] strArr = {"eat","tea","tan","ate","nat","bat"};
		HashMap<String, List<String>> resultantMap = new HashMap<String, List<String>>();
		
		
		
		
		for (String s : strArr) {
			
			//Approach 2 - Using frequencyArray

			int arr[] = new int[26];
			
			char[] charArr = s.toCharArray();
			
			for (char ch : charArr) {
				arr[ch - 'a']++;
			}
			
			StringBuilder sb = new StringBuilder();
			for (int i : arr) {
				sb.append(i);
				sb.append("#");
			}
			
			String key = sb.toString();
			
			 resultantMap.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
			
			
		}
		
		System.out.println(resultantMap.values());
	}
}
