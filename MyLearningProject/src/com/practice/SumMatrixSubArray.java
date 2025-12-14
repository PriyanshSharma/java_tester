package com.practice;

public class SumMatrixSubArray {

	public static void main(String[] args) {
		int[][] arr = {{9, 8, 7},{4, 2, 1},{6, 5, 3}};
		int 		X1=1, Y1=2, X2=3, Y2=3;
		long res =subMatrixSum(arr, 0,0, X1, Y1, X2, Y2);
		System.out.println(res);
	}
	
	 static long subMatrixSum(int arr[][], int n, int m, int x1, int y1, int x2, int y2) {
	       int row = x1-1;
	       int col = y1-1;
	       int maxrow=x2-1;
	       int maxcol = y2-1;
	       int sum = 0 ;
	       for(int i = row;i<=maxrow;i++){
	           for(int j = col; j<=maxcol;j++){
//	        	   System.out.println(arr[i][j]);
	               sum = sum + arr[i][j];
	           }
	       }
	       
	       return sum;
	    }
}
