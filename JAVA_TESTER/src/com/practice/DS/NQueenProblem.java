package com.practice.DS;

public class NQueenProblem {

	public static void main(String[] args) {
		int N = 4;
		int arr[][] = new int[N][N];
		int row = 0;
		boolean isNPlacePossible = nqueen(arr,row,N);
		System.out.println(arr.length);
		System.out.println(isNPlacePossible);
		
		for (int i = 0 ; i < arr.length ; i ++) {
			for (int j = 0 ; j <arr.length ; j ++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean nqueen(int[][] arr, int row, int n) {
		System.err.println("Row = "+row);
		if(row == n) {
			return true;
		}
		
		for(int i = 0 ; i <n ; i++) {
			System.out.println("Column = "+i);
			if(isSafe(arr,row,i)) {
				System.out.println("SAFE = ["+row+"]["+i+"]");

				arr[row][i]=1;
			if(nqueen(arr, row+1, n)) {
					return true;
				}
				arr[row][i] = 0;
			}
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
		// Chek all vertically means Variable row and fixed column
		for (int i =0 ; i <arr.length ; i ++) {
			if (arr[i][c]==1) {
				return false;
			}
		}
		
		//left diagonal
		
		for (int i=row, j=c; i>=0 && j>=0 ; i--,j--) {
			System.out.println("current - ["+i+"]["+j+"]");
			if (arr[i][j]==1) {
				return false;
			}
		}
		
		
		// Right diagnoal
		
		for (int i=row, j=c; i>=0 && j<arr.length ; i--,j++) {
			System.out.println("current - ["+i+"]["+j+"]");
			if (arr[i][j]==1) {
				return false;
			}
		}
		
		return true;
	}
}
