package com.practice.DS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class LongestSubStringNonRepitive {

	/*
	 * Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 */
	
	
	public static void main(String[] args) {
//		new LongestSubStringNonRepitive().lengthOfLongestSubstring("bbbbb");
		String jewels = "z", stones = "ZZ" ;
		 Map<Character,Integer> stoneMap = new HashMap<Character, Integer>();
	        for (char c : stones.toCharArray()){
	            stoneMap.put(c,stoneMap.getOrDefault(c,0)+1);
	        }

	        int count=0;
	        for(char c : jewels.toCharArray()){
	            if(stoneMap.containsKey(c)){
	                count = count + stoneMap.get(c);
	            }
	        }
	    System.out.println(count);
	    new LongestSubStringNonRepitive().lengthOfLongestSubstring("abcbcdeioe");
	}
	
	public int lengthOfLongestSubstring(String s) {
        
		//Steps -- 
		/*
		 * 1. Usig two pointer +sliding window
		 * 2. Maintin 2 pointer l,r at 0 index
		 * increament r 
		 * get curr = s[r]
		 * if map contains the s[r]
		 * start removing all the chars from map till --> while(map.contains(curr)) {map.remove(s[l]) l++} ==>
		 *  this means while we are sliding the position of l, we need to remvoe all the elemnt present left to l from map.
		 *  thus always getting a non-repitive char sset between l and r
		 *  now since the value curr is a repitive earlier, and we have slided till next of previiously availble curr char, thus add the s[r] to map again.
		 *  so that al the value should be present inside map for l to r
		 * 
		 */
		
		int l =0;
		Set<Character> set = new HashSet<Character>();
		int len =0;
		int max=0;
		String res="";
		for (int r = 0 ; r < s.length() ; r++) {
			
			char curr = s.charAt(r);
			
			while (set.contains(curr)) {
				set.remove(s.charAt(l));
				l++;
			}
			
			set.add(curr);
			
			len = r-l+1;
			if(len>max) {
				max=len;
				res=s.substring(l, r+1);
			}
		
		}
		
		System.out.println(res);
		System.out.println(max);
		return max;
    }
}
