package com.practice;

import java.util.*;
public class SumSubArray {
	/*
	 * Get the sub array whose sum of all elements is equal to the  given target sum., Get the indices for the same.
	 * Method we are using is prefix sum array, by using extra space.
	 */
	
	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(1,4,20,3,10,5);
		int target = 33;
		System.out.println(subarraySum(arr, target));
		
		System.out.println(subarraySumByArrayMethod(arr, target));
	}
	  private static List<Integer> subarraySumByArrayMethod(List<Integer> arr, int target) {
		  
		  List<Integer> prefixsumarr = new ArrayList<Integer>();
		  int sum =0;
		  for(int i = 0 ; i < arr.size() ; i++) {
			  sum = sum+arr.get(i);
			  int diff = sum-target;
			  if(prefixsumarr.contains(diff)) {
				  int foundIndex =prefixsumarr.indexOf(diff);
				  return List.of(foundIndex+1,i);
			  }
			  prefixsumarr.add(sum);
		  }
		  return null;
		
	}
	public static List<Integer> subarraySum(List<Integer> arr, int target) {
	        HashMap<Integer, Integer> prefixSums = new HashMap<>();
	        // prefix_sum 0 happens when we have an empty array
//	        prefixSums.put(0, 0);
	        int curSum = 0;
	        for (int i = 0; i < arr.size(); i++) {
	            curSum += arr.get(i);
	            int complement = curSum - target;
	            if (prefixSums.containsKey(complement)) {
	                return List.of(prefixSums.get(complement), i );
	            }
	            prefixSums.put(curSum, i+1 );
	        }
	        return null;
	    }
	  
	 
}
 