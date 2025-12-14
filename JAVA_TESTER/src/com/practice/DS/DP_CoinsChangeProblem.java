package com.practice.DS;

import java.util.Arrays;

public class DP_CoinsChangeProblem {

	public static void main(String[] args) {
		
		int arr[] = {2};
		int w=3;
		int dp[] = new int[w+1];
		Arrays.fill(dp, -1);
		
		int ans = getMinCoinCount(arr, w, dp);
		System.out.println(ans);
	}
	
	
	static int getMinCoinCount(int arr[], int w, int dp[]) {
		
		if(w==0) {
			return 0;
			
		}
		
		if(arr.length==0) {
			return -1;
		}
		
		int ans = Integer.MAX_VALUE;
		
		for (int i =0 ; i<arr.length ; i ++) {
			int returnChangeVal = w-arr[i];
			if (returnChangeVal>=0) {
				
				int subAns=0;
				
				if(dp[returnChangeVal]!=-1) {
					subAns=dp[returnChangeVal];
				}
				else {
					subAns= getMinCoinCount(arr, returnChangeVal, dp);
				}
				
				if(subAns!=Integer.MAX_VALUE
					&& subAns+1<ans) {
					ans=subAns+1;
				}
				else {
					ans=-1;
				}
			}
		}
		dp[w]=ans;
		return ans;
	}
}
