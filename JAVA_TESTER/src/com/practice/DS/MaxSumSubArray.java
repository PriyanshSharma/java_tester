package com.practice.DS;

public class MaxSumSubArray {

// Implementation of kadane's algo- to find the max sum possible with all the sub-arrays

//	if we want to find out the sub array as well --> there are two ways -->
//													1. When ever I m getting a max sum, just store the value of the indexes as well
//													2. We can use two pointer+sliding window technique
// After we found out the sub array, we can able to tell one more answer - max length of the array 
//	and the min length of the array where maximum sum is possible
	
	public static void main(String[] args) {
		int arr[] = 
//			{-3,-2,-2,-3};
			{-2, -5, 6, -2, -3, 1, 5, -6};
//			{2, 3, -8, 7, -1, 2, 3}
//			{1,-2,3,2,-6,4,100,-200};
		int count = 0 ;
		int maxsum=Integer.MIN_VALUE;
		int strt=0;
		int end=arr.length-1;
		for(int i=0; i < arr.length;i++) {
			count = count+arr[i];
			
			if(maxsum<count) {
				maxsum=count;
				end=i;
			}
			if(count<0) {
				count=0;
				if(i<arr.length-1) {
					strt=i+1;
				}
				
			}
		}
		
		System.out.println(maxsum);
		System.out.println("subArray = "+strt+" - "+end);
	}
}
