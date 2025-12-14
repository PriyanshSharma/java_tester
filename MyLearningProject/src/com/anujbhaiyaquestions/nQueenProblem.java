package com.anujbhaiyaquestions;

public class nQueenProblem {

	public static void main(String[] args) {
		int N = 4;
		int arr[][] = new int[N][N];
		int row = 0;
		boolean isNPlacePossible = nqueen(arr,row,N-1);
	}

	private static boolean nqueen(int[][] arr, int row, int n) {
		
		if(row == n) {
			return true;
		}
		
		for(int i = 0 ; i <n ; i++) {
			if(isSafe(arr,row,i)) {
				arr[row][i]=1;
			}
			
			if(nqueen(arr, row+1, n)) {
					return true;
				}
				arr[row][i] = 0;
			
		}
		
		return false;
	}

	private static boolean isSafe(int[][] arr, int row, int c) {
		//checkrow 
		
		//Check row - horizontal - means same row column changing 
		
		for (int i =0 ; i <arr.length ; i ++) {
			if (arr[row][i]==1) {
				return false;
			}
		}
		// Chek all Column means Variable row and fixed column
		for (int i =0 ; i <arr.length ; i ++) {
			if (arr[i][c]==1) {
				return false;
			}
		}
		
		//left diagonal
		
		for (int i=row, j=c; i>=0 && j>=0 ; i--,j--) {
			if (arr[i][j]==1) {
				return false;
			}
		}
		
		
		// Right diagnoal
		
		for (int i=row, j=c; i>=0 && j<=arr.length ; i--,j++) {
			if (arr[i][j]==1) {
				return false;
			}
		}
		
		return true;
	}
}
