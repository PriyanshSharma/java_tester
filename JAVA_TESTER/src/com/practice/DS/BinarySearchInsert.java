package com.practice.DS;

public class BinarySearchInsert {

	
	
	public static void main(String[] args) {
		int arr[] = 	{2, 4, 6, 8, 10};
		//System.out.println(searchInsert(arr, 3));
		System.out.println(upperBound(arr, 6));
	}
	 public static int searchInsert(int[] nums, int target) {
	        
	        int mid = 0 ; 
	        int low = 0 ; 
	        int high = nums.length-1;
	        int answer=-1;
	        while (low<=high){
	            mid = (low+high)/2;

	            if(nums[mid]==target) {
	            	//updating the answer to latest mid index to trying to get the first occurence of the value
	            	answer=mid;
	            	high=mid-1;
	            }
	            
	            else if (target<nums[mid]) {
	            	high = mid-1;
	            }
	            else {
	            	low = mid+1;
	            }
	        }
	        if(answer==-1) {
	        	return low;
	        }
	        else {
	        	return answer;
	        }
	    }
	 
	 
	 public static int upperBound(int[] nums, int target) {
	        
	        int mid = 0 ; 
	        int low = 0 ; 
	        int high = nums.length-1;
	        int answer=-1;
	        while (low<=high){
	            mid = (low+high)/2;

	            if(nums[mid]>target) {
	            	//updating the answer to latest mid index to trying to get the first occurence of the value such that ans is just greater than 
	            	answer=mid;
	            	high = mid-1;
	            	
	            }
	            
	            else {
	            	low=mid+1;
	            	
	            }
	        }
	       return answer;
	    }
}
