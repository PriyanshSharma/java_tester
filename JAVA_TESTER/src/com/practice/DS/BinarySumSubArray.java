package com.practice.DS;

public class BinarySumSubArray {

	public static void main(String[] args) {
		BinarySumSubArray b = new BinarySumSubArray();
		int arr[] = {1,0,1,0,1};
		int k = 2;
		int ans =b.numSubarraysWithSum(arr, k)-b.numSubarraysWithSum(arr, k-1);
		System.out.println(ans);
	}
	
	 public int numSubarraysWithSum(int[] arr, int goal) {
	        
		 int r=0, l=0, sum=0,subArrayCount=0;
		 int n = arr.length;
		 
		 while (r<n) {
			 
			 sum = sum + arr[r];
			 
			 while (sum>goal) {
				 
				 if(arr[l]==1) {
					 sum=sum-1;
				 }
				 l++;
			 }
			 
			if (sum<=goal) {
				 subArrayCount = subArrayCount+(r-l+1); 
				// Here we are doing additionally (r-l+1) get all the sub arrays behind r
				 // i.e. sub-arrays that can be formed behind the r, following the condition
			 }
			r++;
		 }
		 return subArrayCount;   
	 }
}
