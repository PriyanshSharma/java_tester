package com.practice.DS;

import java.util.ArrayList;
import java.util.List;

/*
 * 131. Palindrome Partitioning
	Medium
	Topics
	premium lock icon
	Companies
	Given a string s, partition s such that every substring of the partition is a palindrome. 
	Return all possible palindrome partitioning of s.
	
	Example 1:
	
	Input: s = "aab"
	Output: [["a","a","b"],["aa","b"]]
	Example 2:
	
	Input: s = "a"
	Output: [["a"]]
 */
public class PallendRomePartioning {

	public static void main(String[] args) {
		new PallendRomePartioning().partition("aabb");
	}
	
	 public List<List<String>> partition(String s) {
	       
		 List<String> list = new ArrayList<String>();
		 List<List<String>> result = new ArrayList<List<String>>();
		 
		 getAllPallendPart(s,list,result);
		 return result;
		 
		 
	    }

	private void getAllPallendPart(String s,List<String> list, List<List<String>> result) {

		if (s.length()==0) {
			System.out.println(list);
			List<String> l = new ArrayList<String>();
			l.addAll(list);
			result.add(l);
			return;
		}
		
		for (int i = 0 ; i< s.length() ; i ++) {
			
			String partleft = s.substring(0, i+1);
			
			if (isPallendRome(partleft)) {
				list.add(partleft);
				String rem = s.substring(i+1);
				getAllPallendPart(rem, list, result);
				list.remove(list.size()-1);
			}
		}
	}

	private boolean isPallendRome(String partleft) {
		
		int start=0;
		int end = partleft.length()-1;
		while (start<end) {
			if (partleft.charAt(start++)!=partleft.charAt(end--)) {
				return false;
			}
			
		}
		return true;
	}
}






























