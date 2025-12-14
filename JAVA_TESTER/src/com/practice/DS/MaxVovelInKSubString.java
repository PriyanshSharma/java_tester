package com.practice.DS;


/*
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

	Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
	
	 
	
	Example 1:
	
	Input: s = "abciiidef", k = 3
	Output: 3
	Explanation: The substring "iii" contains 3 vowel letters.
	Example 2:
	
	Input: s = "aeiou", k = 2
	Output: 2
	Explanation: Any substring of length 2 contains 2 vowels.
	Example 3:
	
	Input: s = "leetcode", k = 3
	Output: 2
	Explanation: "lee", "eet" and "ode" contain 2 vowels.
 */
public class MaxVovelInKSubString {

	public static void main(String[] args) {
		
		String s = "leetcode";
		int k = 3;
		System.out.println(new MaxVovelInKSubString().maxVowels(s, k));
	}
	
	 public int maxVowels(String s, int k) {
	        int maxC =0;
	        
	        int r=0,l=0,count=0;
	        
	        while (r<s.length()) {
	        	if (isVovel(s.charAt(r))) {
	        		count++;
	        	}
	        	
	        	if (r-l+1 == k) {
	        		maxC = Math.max(maxC, count);
	        		
	        		if (isVovel(s.charAt(l))) {
	        			count--;
	        		}
	        		
	        		l++;
	        	}
	        	r++;
	        }
	        
	        return maxC;
	  }

	private boolean isVovel(char c) {
		
		return c=='a' || c=='e'||c=='i' || c=='o' || c=='u';
	}
	 
	 
}





















