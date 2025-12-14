package com.practice;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {

	public static void main(String[] args) {
        int[][] board = new int[][] { 
        		{1, 2, 3, 4, 5, 6, 7, 8, 9}, 
        		{4, 5, 6, 7, 8, 9, 1, 2, 3}, 
        		{7, 8, 9, 1, 2, 3, 4, 5, 6}, 
        		{2, 1, 4, 3, 6, 5, 8, 9, 7}, 
        		{3, 6, 5, 8, 9, 7, 2, 1, 4}, 
        		{8, 9, 7, 2, 1, 4, 3, 6, 5}, 
        		{5, 3, 1, 6, 4, 2, 9, 7, 8}, 
        		{6, 4, 2, 9, 7, 8, 5, 3, 1}, 
        		{9, 7, 8, 5, 3, 1, 6, 4, 1}
        };
        solveSudoku(board, 0);
        printBoard(board);
        
        
        
    }
	
	 private static boolean solveSudoku(int[][] a, int row) {
		 boolean isSolved = true;
		 int column=0;
		 List<Integer> numList = new ArrayList<Integer>();
		do {
			while(row<9) {
				numList.clear();
				 for(int col = 0 ; col<9; col++) {
					 if(!numList.contains(a[row][col])) {
						 numList.add(a[row][col]);
					 }
					 else {
						 isSolved=false;
						 return isSolved;
					 }
				 }
				
			 }
			while (column<9) {
				numList.clear();
				for(int r =0; r<9;r++) {
					if(!numList.contains(a[r][column])) {
						 numList.add(a[r][column]);
					 }
					 else {
						 isSolved=false;
						 return isSolved;
					 }
				}
			}
			row++;
			column++;
		}while(isSolved && row <9 && column<9);
		 
		return isSolved;

	    }


	    private static void printBoard(int[][] board) {
	        for (int[] row : board) {
	            for (int i : row) {
	                System.out.print(i + ", ");
	            }
	            System.out.println();
	        }

	    }
}
