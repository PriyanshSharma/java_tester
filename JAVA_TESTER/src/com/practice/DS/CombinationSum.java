package com.practice.DS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique
 if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 */

public class CombinationSum {
	public static void main(String[] args) {
		int arr[] = {2,3,6,7};
		int target = 7;
		int i = 0 ;
//		List<Integer> adder = new ArrayList<Integer>();
//		Set<List<Integer>> result = new HashSet<List<Integer>>();
//		getCombinationSumResult(arr,i,target, adder,result);
//		System.out.println(result);
		
		System.out.println(new CombinationSum().combinationSum(arr, target));
		
	}

	private static void getCombinationSumResult(int[] arr, int ind, int target, List<Integer> adder,
			Set<List<Integer>> result) {
		
		if (target==0) {
			
			List<Integer> l = new ArrayList<Integer>();
			l.addAll(adder);
			
			result.add(l);
			return;
		}
		
		
		
		
		for (int i = ind ; i < arr.length ; i ++) {
			
			if (i>ind && arr[i]==arr[i-1]) {
				continue;
			}
			if (arr[i]>target) {
				break;
			}
			
			adder.add(arr[i]);
			getCombinationSumResult(arr, i+1, target-arr[i], adder, result);
			adder.remove(adder.size()-1);
		}
		
	}
	
	
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 List<Integer> list = new ArrayList<Integer>();
	        getAllWithRepitionsCombinationSum (candidates, 0, target, list,result);
	        
	        return result;
	    }

	 private void getAllWithRepitionsCombinationSum(int[] arr, int i, int target, List<Integer> list,
			List<List<Integer>> result) {
		
		if (i==arr.length) {
			if (target==0) {
				System.out.println(list);
				List<Integer> l = new ArrayList<Integer>();
				l.addAll(list);
				result.add(l);
			}
			
			return;
		}
		
		
		
		if (arr[i]<=target) {
			list.add(arr[i]);
			getAllWithRepitionsCombinationSum(arr, i, target-arr[i], list, result);
			list.remove(list.size()-1);
		}
		getAllWithRepitionsCombinationSum(arr, i+1, target, list, result);
		
	}
}

































