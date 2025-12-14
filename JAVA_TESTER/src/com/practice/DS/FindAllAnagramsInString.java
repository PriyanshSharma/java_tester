package com.practice.DS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. 
 * You may return the answer in any order.

 	Example 1:
	
	Input: s = "cbaebabacd", p = "abc"
	Output: [0,6]
	Explanation:
	The substring with start index = 0 is "cba", which is an anagram of "abc".
	The substring with start index = 6 is "bac", which is an anagram of "abc".
	Example 2:
	
	Input: s = "abab", p = "ab"
	Output: [0,1,2]
	Explanation:
	The substring with start index = 0 is "ab", which is an anagram of "ab".
	The substring with start index = 1 is "ba", which is an anagram of "ab".
	The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInString {


	public static void main(String[] args) {
		String s = "abab";
		String p = "ab";
		List l = new FindAllAnagramsInString().findAnagrams(s, p);
		
		System.out.println(l);
	}
	
	public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> results = new ArrayList<Integer>();
        int countReq=p.length();
        int l=0,r=0;
        
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        
        for (char c : p.toCharArray()) {
        	map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        while (r<s.length()) {
        	char c = s.charAt(r);
        	if(map.containsKey(c)) {
        		if (map.get(c)>0) {
        			countReq--;
        		}
        		
        		map.put(c, map.get(c)-1);
        	}
        	
        	while (countReq==0) {
        		
        		
        		// If subString found--
        		if ((r-l+1) == p.length()) {
        			results.add(l);
        			System.out.println(s.substring(l,r+1));
        		}
        		
        		if (map.containsKey(s.charAt(l))) {
        			map.put(s.charAt(l), map.get(s.charAt(l))+1);
        			
        			if (map.get(s.charAt(l))>0){
        				countReq++;
        			}
        		}
        		
        		l++;
        	}
        	r++;
        }
        
        
        Queue<Integer> q = new LinkedList<Integer>();
        return results;
        		
    }
	
}































