package com.practice.DS;

import java.util.Arrays;

/**
 * You are given an array with unique elements of stalls[], which denote the position of a stall. 
 * You are also given an integer k which denotes the number of aggressive cows. 
 * Your task is to assign stalls to k cows such that the minimum distance between any two 
 * of them is the maximum possible.
 * 
 * Input: stalls[] = [1, 2, 4, 8, 9], k = 3
	Output: 3
	Explanation: The first cow can be placed at stalls[0], 
	the second cow can be placed at stalls[2] and 
	the third cow can be placed at stalls[3]. 
	The minimum distance between cows, in this case, is 3, which also is the largest among all possible ways.
 */

public class AggresiveCows {

	public static void main(String[] args) {
		int arr[] = {10, 1, 2, 7, 5};
		int k =3;
		System.out.println(
		aggressiveCows(arr, k));
	}
	public static int aggressiveCows(int[] arr, int k) {
		Arrays.sort(arr);
		int low = 1;
		int n = arr.length;
		int high = arr[n-1]-arr[0];
		
		//BruteForceWay Linear search between the range
		
//		int ans =0;
//		for (int i = low ; i <=high ; i ++) {
//			
//			if (isPossibleToPlaceCowsWithI(arr,i,k)) {
//				ans=i;
//			}
//		}
//		return ans;
		
		//Apply Binary search for the same.
		
		while (low<=high) {
			int mid = (low+high)/2;
			
			if (isPossibleToPlaceCowsWithI(arr, mid, k)) {
				low = mid+1;
			}
			else {
				high=mid-1;
			}
		}
				

		return high;
    }
	private static boolean isPossibleToPlaceCowsWithI(int[] arr, int distance, int k) {

		int countCow = 1;
		int lastPlacedAt = arr[0];
		for (int i = 1 ; i < arr.length ; i ++) {
			int diff = arr[i]-lastPlacedAt;
			
			if (diff>=distance) {
				countCow++;
				lastPlacedAt=arr[i];
				
			}
			
			if (countCow>=k) {
				return true;
			}
		}
		return false;
	}
	
}
