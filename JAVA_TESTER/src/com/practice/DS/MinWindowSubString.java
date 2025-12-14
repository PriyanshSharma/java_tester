package com.practice.DS;

import java.util.HashMap;
import java.util.Map;

/*
 * Given two strings s and t of lengths m and n respectively, 
 * return the minimum window substring of s such that every 
 * character in t (including duplicates) is included in the window. 
 * If there is no such substring, return the empty string "".
 * Example 1:

	Input: s = "ADOBECODEBANC", t = "ABC"
	Output: "BANC"
	Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
	Example 2:
	
	Input: s = "a", t = "a"
	Output: "a"
	Explanation: The entire string s is the minimum window.
	Example 3:
	
	Input: s = "a", t = "aa"
	Output: ""
	Explanation: Both 'a's from t must be included in the window.
	Since the largest window of s only has one 'a', return empty string.
 */

public class MinWindowSubString {

	public static void main(String[] args) {
		MinWindowSubString minOb = new MinWindowSubString();
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+"AbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
		
		
		
		
		
		
		String t = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
		System.out.println(minOb.minWindow(s, t));
	}
	
	public String minWindow(String s, String t) {
        
		if (s.length()<t.length()) {
			return "";
		}
		int r = 0, l=0, minLen =Integer.MAX_VALUE, startIndex=0;
		int counterReq =t.length();
		
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		char arr[] = s.toCharArray();
		for (char c :t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		while (r<s.length()) {
			char c = arr[r];
			System.out.println(c);
			if (map.containsKey(c)) {
				if (map.get(c)>0) {
					counterReq--;
				}
				map.put(c, map.get(c)-1);
			System.out.println(map.toString());	
			}
			
			
			while (counterReq==0) {
				if(minLen>(r-l+1)) {
					minLen = r-l+1;
					startIndex = l;
					
					System.err.println(minLen+" = "+startIndex);
				}
				if (map.containsKey(arr[l])) {
					map.put(arr[l], map.get(arr[l])+1);
					if (map.get(arr[l])>0) {
						counterReq++;
					}
				}
				l++;
			}
			r++;
		}
		
		
		
		
		return minLen==Integer.MAX_VALUE ? "": s.substring(startIndex, startIndex+minLen);
    }
}



















