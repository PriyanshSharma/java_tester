package com.practice.DS.dynamicprog;

import java.util.Arrays;

public class HouseRobber {

	public static void main(String[] args) {
		int num[] = {2,7,9,3,1};
		int ans = new HouseRobber().rob(num);
		
		System.out.println(ans);
	}
	
	 public int rob(int[] nums) {
		 
		 int n = nums.length;
		 int dp[] = new int[n+1];
		 Arrays.fill(dp, -1);
		 int index=n-1;
		 return robUtilmeoization(index,nums,dp);
	 }

	private int robUtilmeoization(int index, int[] nums, int[] dp) {
		
		if (index==0) {
			return nums[index];
		}
		dp[0] =nums[0];
		
		if (dp[index ]!=-1) {
			return dp[index];
		}
		int pickup = nums[index] ;
		
		if (index>1) {
			pickup+= robUtilmeoization(index-2, nums, dp);
		}
				
				
		int notPic = 0 + robUtilmeoization(index-1, nums, dp);
		
		dp[index] = Math.max(pickup, notPic); 
				
		return dp[index];
	}
	
	
}

