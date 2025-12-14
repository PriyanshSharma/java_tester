package com.practice.DS;

import java.util.Arrays;

/**
 * Given an array of integers nums and an integer threshold, we will choose a positive integer divisor,
 *  divide all the array by it, and sum the division's result. Find the smallest divisor such that 
 *  the result mentioned above is less than or equal to threshold.
 *  Each result of the division is rounded to the nearest integer greater than or equal to that element. 
 *  (For example: 7/3 = 3 and 10/2 = 5).
 *  
 *  Example 1:
 *  Input: nums = [1,2,5,9], threshold = 6
	Output: 5
	Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
	If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 
	Example 2:
	
	Input: nums = [44,22,33,11,1], threshold = 5
	Output: 44
 */
public class SmallestDivisrGivenThreshold {

	public static void main(String[] args) {
		int arr[] = {44,22,33,11,1};
		int t = 5;
		
		System.out.println(
		new SmallestDivisrGivenThreshold().smallestDivisor(arr, t));
	}
	

	public int smallestDivisor(int[] nums, int threshold) {
        
		int low = 1;
		int high = Arrays.stream(nums).max().orElse(0);
		
		/**
		 * Linear search
		 */
//		for (int i = low ; i <=high ; i ++) {
//			
//			int sumWithCurrentDivisor = getSumForAllDivisors(nums,i);
//			
//			if (sumWithCurrentDivisor<=threshold) {
//				return i;
//			}
//		}
		/**
		 * Optimising using binary search
		 */
		
		while (low<=high) {
			int mid = (low+high)/2;
			
			int sumWithCurrentDivisor = getSumForAllDivisors(nums,mid);
			
			if (sumWithCurrentDivisor>threshold) {
				low = mid+1;
			}
			else {
				high=mid-1;
			}
			
		}
		
		return  low;
    }


	private int getSumForAllDivisors(int[] arr, int divisor) {

		int sum = 0 ;
		for (int i = 0 ; i < arr.length ; i ++) {
			sum += Math.ceil((double)arr[i]/(double)divisor);
		}
		return sum;
	}
}











