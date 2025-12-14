package com.practice.DS.dynamicprog;

public class MaximalSquareSubMatrix {

	public static void main(String[] args) {
		char arr[][] = 
//			{{'1'}};
//			{{'0','1'},{'1','0'}};
				/*
				 * { {'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'},
				 * {'1','0','0','1','0'} };
				 */
		{{'1','1','1','1','0'},
			{'1','1','1','1','0'},
			{'1','1','1','1','1'},
			{'1','1','1','1','1'},
			{'0','0','1','1','1'}
		};
		
		System.out.println(maximalSquare(arr));
		
	}
	
	
	 public static int maximalSquare(char[][] matrix) {
	        
			 int r = matrix.length;
			 int c = matrix[0].length;
			 int dp [][] = new int[r][c];
			 
			 int max = 0;
			 
			for (int i = 0 ; i < c ; i++) {
				 dp[0][i]=Integer.parseInt(String.valueOf(matrix[0][i]));
				 if (dp[0][i]==1 && max!=1) {
					 max=1;
				 }
			}
			
			for (int i = 0 ; i < r ; i++) {
				 dp[i][0]=Integer.parseInt(String.valueOf(matrix[i][0]));
				 if (dp[i][0]==1 && max!=1) {
					 max=1;
				 }
			}
			 
			 
			 for (int i = 1 ; i < r ; i ++) {
				 for (int j = 1 ; j<c ; j++) {
					  
					 if (Integer.parseInt(String.valueOf(matrix[i][j]))!=0) {
						 dp[i][j] = 1+Math.min(dp[i-1][j-1], 
								 Math.min(dp[i][j-1], dp[i-1][j]));
						 System.out.println(dp[i][j]);
						 max = Math.max(max, dp[i][j]);
					 }
					 else {
						 dp[i][j]=0;
					 }
				 }
			 }
			 
			 return max*max;
		 }
	 
	 
	 public static int countSquares(int[][] matrix) {
	        
	        int count =0;
			 int r = matrix.length;
			 int c = matrix[0].length;
			 int dp [][] = new int[r][c];
			 
			 int max = 0;
			 
			for (int i = 0 ; i < c ; i++) {
				 dp[0][i]=Integer.parseInt(String.valueOf(matrix[0][i]));
				 if (dp[0][i]==1) {
					 max=1;
                  count++;
				 }
			}
			
			for (int i = 0 ; i < r ; i++) {
				 dp[i][0]=Integer.parseInt(String.valueOf(matrix[i][0]));
				 if (dp[i][0]==1) {
					 max=1;
                  count++;
				 }
			}
			 
			 
			 for (int i = 1 ; i < r ; i ++) {
				 for (int j = 1 ; j<c ; j++) {
                 
             	 if (Integer.parseInt(String.valueOf(matrix[i][j]))!=0) {
                     count++;
						 dp[i][j] = 1+Math.min(dp[i-1][j-1], 
								 Math.min(dp[i][j-1], dp[i-1][j]));
					
                      if (max<dp[i][j]){
                          max = Math.max(max, dp[i][j]);
                          count++;
                      }
						
					 }
					 else {
						 dp[i][j]=0;
					 }
				 }
			 

               }
			
			 return count;
 }
}
