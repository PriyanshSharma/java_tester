package com.practice.DS;

/**
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.

 

Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 
 */
public class KthMissingPositiveNumber {

	public static void main(String[] args) {
		int arr[] = {1,3};
		int k = 1;
		System.out.println(new KthMissingPositiveNumber().findKthPositive(arr, k));
	}
	
	public int findKthPositive(int[] arr, int k) {
        
		if (k<arr[0]) {
			return k;
		}
		
		int low = 0 ; int high = arr.length-1;
		
		while (low<=high) {
			
			int mid = (low+high)/2;
			
			// Find missing element at mid
			int missingAtIndex = arr[mid]-(mid+1); // arr = {2,3,4,7,11} - Missing at 0 index = 1 
												   // how ideally there should be 1 but is 2
													// formula = 2-(0+1) = 1 - means 1 number is missing at 0th index
			
			if (missingAtIndex<k) {
				low=mid+1;
			}
			else {
				high=mid-1;
			}
		}
		
		/*
		 * once binary search completed, means high will be pointing to a index after which some where
		 * I will get the kth missing missing
		 * so currently after binary search completed high will point to 7 element in the arr.
		 * so at 7 missing = 7-(3+1) = 3 elements
		 * i.e. at 7, 3 elements are missing, thus we need two more
		 * more = k-(currentMissing) => k- (arr[high] + more) = will be the answer 
		 * more = k-(currentMissing)
		 * currentMissing = arr[high]-(high+1)
		 * kth element = arr[high]+more
		 * =>arr[high] + k - (arr[high]-(high+1))
		 * =>arr[high] + k - (arr[high] -high -1)
		 * =>arr[high] + k -arr[high] +high +1
		 * =>k+high+1
		 * =>k+low {low = high+1}
		 */
		return k+low;
    }
	
}












