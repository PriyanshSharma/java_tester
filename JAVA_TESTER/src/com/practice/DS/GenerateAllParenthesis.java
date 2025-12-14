package com.practice.DS;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllParenthesis {

	/*
	 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

		Example 1:
		
		Input: n = 3
		Output: ["((()))","(()())","(())()","()(())","()()()"]
		Example 2:
		
		Input: n = 1
		Output: ["()"]
	 */
	
	
	public static void main(String[] args) {
		System.out.println(new GenerateAllParenthesis().generateParenthesis(3));
	}
	
	 public List<String> generateParenthesis(int n) {
	     List<String> ans= new ArrayList<String>();
	     generateAll(n,ans,"",0,0);
	     return ans;
	   }

	 private void generateAll(int n, List<String> ans, String s,int openCount, int clsCount) {
		
		if (s.length()==2*n) {
			ans.add(s);
			return;
		}
		
		//Aadd open bracet
		if (openCount<n) {
			generateAll(n, ans, s+"(",openCount+1,clsCount);
			
		}
		
		//Add Close - No need of bracktrack becz we are altering the string itself, so when it comes back
		// next operation will be performed on s not on s+"("
		
		if (clsCount<openCount) {
			generateAll(n, ans, s+")",openCount, clsCount+1);

		}
	}
}


















