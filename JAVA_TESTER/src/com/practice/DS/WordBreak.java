package com.practice.DS;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

	public static void main(String[] args) {
		String s = "appleapplepenpenapple";
		List<String> words = Arrays.asList("apple","pen");
		boolean flag = new WordBreak().wordBreak(s, words);
		
		System.out.println(flag);
		System.err.println(1 + 2 - 4 * 12);
	}
	
	 public boolean wordBreak(String s, List<String> wordDict) {
	      
	  
		 return getAllWithRepitionsCombinationSum (s,"",wordDict);

	  }
	
	
	 private boolean getAllWithRepitionsCombinationSum(String s, String adder, List<String> wordDict) {
		
		if (adder.length()==s.length()) {
			if (s.equals(adder)) {
				return true;
			}
			return false;
		}
		
		for (int i=0; i <wordDict.size() ; i ++ ) {
			
			if (s.length()>=adder.length()) {
				
				if (getAllWithRepitionsCombinationSum(s, adder+wordDict.get(i), wordDict)) {
					return true;
				}
				
			}	
		}
		
		return false;
		
	}
}
