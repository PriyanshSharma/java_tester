package com.practice.DS;

import java.util.Arrays;

/**
 * Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

	Return the minimized largest sum of the split.

	A subarray is a contiguous part of the array.
	
	
	Example 1:

	Input: nums = [7,2,5,10,8], k = 2
	Output: 18
	Explanation: There are four ways to split nums into two subarrays.
	The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
	
	Example 2:
	
	Input: nums = [1,2,3,4,5], k = 2
	Output: 9
	Explanation: There are four ways to split nums into two subarrays.
	The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 	
 	As it is same as MinBookAllocation problem
 */
public class SplitArraylargestSum {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		int k =3;
//		System.out.println(
//		new SplitArraylargestSum().splitArray(arr, k));
		
		System.out.println(
		new SplitArraylargestSum().splitArrayOpposite(arr, k));
	}
	
	public int splitArray(int[] nums, int k) {
        
		
		int low = Arrays.stream(nums).max().orElse(0);
		int high = Arrays.stream(nums).sum();
		
		while (low <=high) {
			int mid = (low+high)/2;
			int partitiopossibleWithGivenSum = getPartitionsPossibleWithGivenMaxSum(nums, mid);
			if (partitiopossibleWithGivenSum>k) {
				
				low=mid+1;
			}
			else {
				high=mid-1;
			}
		}
		return low;
    }

	private int getPartitionsPossibleWithGivenMaxSum(int[] nums, int maxSum) {

		//[10,20,30,40] k=2
		
		int currSum =0;
		int possibleParition=1;
		
		for (int i = 0 ; i <nums.length ; i++) {
			
			currSum = currSum+nums[i];
			
			if (currSum<=maxSum) {
				continue;
			}
			else {
				
				possibleParition++;
				currSum=nums[i];
			}
			
			
		}
		
		return possibleParition;
	}
	
	
	public int splitArrayOpposite(int nums[] , int k) {
		
		
		int low = Arrays.stream(nums).min().orElse(0);
		int high = Arrays.stream(nums).sum();
		int result =0;
		
		for (int i = low ; i <=high ; i ++) {
			int partitiopossibleWithGivenSum = getPartitionsPossibleWithGivenMinSum(nums, i);
			System.out.println("Partitions "+partitiopossibleWithGivenSum+" for given sum = "+i);
		}
		while (low <=high) {
			int mid = (low+high)/2;
			int partitiopossibleWithGivenSum = getPartitionsPossibleWithGivenMinSum(nums, mid);
			
			if (partitiopossibleWithGivenSum>=k) {
				result = mid;
				low=mid+1;
			}
			else {
				high=mid-1;
			}
		}
		return high;
	}
	
	
	private int getPartitionsPossibleWithGivenMinSum(int[] nums, int minSum) {

		//[10,20,30,40] k=2
		
		int currSum =0;
		int possibleParition=0;
		
		for (int i = 0 ; i <nums.length ; i++) {
			
			currSum = currSum+nums[i];
			
			if (currSum>=minSum) {
				possibleParition++;
				currSum=0;
			}
			
			
		}
		
		return possibleParition;
	}
	
}











