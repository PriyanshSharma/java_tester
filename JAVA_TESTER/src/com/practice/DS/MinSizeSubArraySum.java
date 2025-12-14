package com.practice.DS;

public class MinSizeSubArraySum {

	
	//whose sum is greater than or equal to target
	
	public static void main(String[] args) {
		int arr[] = {2,3,1,2,4,3};
		int k = 7;
		
		int ans = new MinSizeSubArraySum().minSubArrayLen(k,arr);
		System.out.println(ans);
	}
	
	 public int minSubArrayLen(int target, int[] arr) {
		 int start=0;
		 int end =0;
		 int l = 0 ; 
		 int r = 0;
		 int n = arr.length;
		 int sum = 0;
		 int min = Integer.MAX_VALUE;
		 for (int i =0 ; i < n ;i++) {
				sum = sum + arr[i];
				 
				while (l<n && sum>=target) {
					 min = Math.min(min, i-l+1);
					 start =l;
					 end = i;
					 sum = sum - arr[l];
					 l++;
				 }
			 }
		System.out.println("Sub-Array - ["+start+" - "+end+"]");
		 return min;
	  }
}
