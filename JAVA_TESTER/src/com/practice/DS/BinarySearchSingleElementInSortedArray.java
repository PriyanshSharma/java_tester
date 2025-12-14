package com.practice.DS;

public class BinarySearchSingleElementInSortedArray {

	
	/*
	 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
		Return the single element that appears only once.
		Your solution must run in O(log n) time and O(1) space.
		Example 1:
		Input: nums = [1,1,2,3,3,4,4,8,8]
		Output: 2
		Example 2:
		Input: nums = [3,3,7,7,10,11,11]
		Output: 10
 		
 		Solution -- 
 		
 		get the mid
 		if mid is single element - yes - return
 		else - elemeinate atleast one half
 		
 		in array if every element is apearing twice = lenth of array = even
 		so If extra element is present = lenght of array is odd
 		so when ever we divide the array from mid.
 		
 		there are two case -- both halfs will containing equal element - either odd or even.
 		
 		if even --> 
 			check where next occureance of mid is available -- 
 				if arr[mid] == arr[mid -1 ] == meaning the next repeat valu of mid is present in left half - that means arr[mid] and arr[mid-1] 
 				are equal and pair, thus the remaining elements will be odd.
 				
 				so if remaning elements are odd leaving a pair of mid means the value is present in left --> eliminate right half
 		if Odd --> 
 			Check the present of next duplicate of mid, if it is present in left of mid i.e. at mid-1 means now only even elements are remaining, means move to right half
 			same if duplicate of mid is present right of mid i.e. at mid+1, means right half will become even as mid and mid+1 are same, thus element is present in left half, elimincate right.
 		
 		
	 */
	
	
	public int singleNonDuplicate(int[] arr) {
        
		int l = 0 ; 
		int h = arr.length-1;
		int n = arr.length;
		
		int ansIndex=-1;
		
		while (l<=h) {
			int mid = (l+h)/2;
			
			if(arr.length==0) {
				break;
			}
			
			if (arr.length==1) {
				ansIndex=arr[0];
				break;
			}
			if(arr[0]!=arr[1]) {
				ansIndex=arr[0];
				break;
			}
			if(mid==n-1 && arr[n-1]!=arr[n-2]) {
				ansIndex = arr[n-1];
				break;
			}
			
			if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]) {
				ansIndex= arr[mid];
				break;
			}
			
			
			
				// if mid is even = both halfs contains even elements
				if(mid%2==0) {
					if(arr[mid]==arr[mid-1]) {
						h=mid-1;
					}
					else if (arr[mid]==arr[mid+1]) {
						l = mid+1;
					}
				}
				// both halfs contains odd elements
				else {
					if(arr[mid]==arr[mid-1]) {
						l=mid+1;
						
					}
					else if (arr[mid]==arr[mid+1]) {
						h=mid-1;
					}
				}
				
			}
			
		
		return ansIndex;
    }
	
	
	public static void main(String[] args) {
		int arr[] = {1,1,2,2,3};
		int val = new BinarySearchSingleElementInSortedArray().singleNonDuplicate(arr);
		System.out.println(val);
	}
}
