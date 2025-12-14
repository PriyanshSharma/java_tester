package com.practice.DS.dynamicprog;

import java.util.Arrays;

public class ClimbStairs {
	
	public static void main(String[] args) {
		
		int n=3;
		int ans = new ClimbStairs().climbStairs(n);
		System.out.println(ans);
	}

	
public int climbStairs(int n) {
        
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
         return climbHeperDPTabulation(n, dp);
    }


    private int climbHeperDPMemoization(int n , int[]dp){

        if (n==0){
            return 1;
        }

        if (n==1){
            return 1;
        }

        dp[0]=1;
        dp[1]=1;

        if (dp[n]!=-1){
            return dp[n];
        }

        dp[n] = climbHeperDPMemoization(n-1, dp) + climbHeperDPMemoization (n-2,dp);

        return dp[n];
    }
    
    
    private int climbHeperDPTabulation(int n , int[]dp){

       

        dp[0]=1;
        dp[1]=1;

        
        for (int i = 2 ; i <=n ; i++) {
        	dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
