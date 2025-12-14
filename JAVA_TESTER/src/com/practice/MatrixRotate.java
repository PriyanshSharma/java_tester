package com.practice;

import java.util.Scanner;

public class MatrixRotate {

	
	
	    public static void main(String[] args) {
//	        Scanner scanner = new Scanner(System.in);
//	 
//	        System.out.println("Enter number of rows:");
//	        int rows = scanner.nextInt();
//	 
//	        System.out.println("Enter number of columns:");
//	        int cols = scanner.nextInt();
//	 
//	        int[][] matrix = new int[rows][cols];
//	 
//	        System.out.println("Enter matrix elements row-wise:");
//	 
//	        for (int i = 0; i < rows; i++) {
//	            for (int j = 0; j < cols; j++) {
//	                matrix[i][j] = scanner.nextInt();
//	            }
//	        }
//	 
//	        System.out.println("You entered matrix:");
	 
	        
	 
//	        scanner.close();
	    	
	    	int rows = 3;
	    	int cols = 3;
	        int[][] matrix = {
	        	    {1, 2, 3, 4},
	        	    {4, 5, 6, 5},
	        	    {7, 8, 9, 6}
	        	};
	        
	        int[][] matrix1 = {
	        	    {1, 2, 3},
	        	    {4, 5, 6},
	        	    {7, 8, 9}
	        	};
	        
	        System.out.println("Current matrix -- ");
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < cols; j++) {
	                System.out.print(matrix1[i][j] + " ");
	            }
	            System.out.println();
	        }
	        getMatriXRotated(matrix1, rows, cols);
	        
	        System.out.println("After change  matrix -- ");
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < cols; j++) {
	                System.out.print(matrix1[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }
	    
	    
	    
	    
	   public static void getMatriXRotated(int arr[][], int row, int col){

		   getTransposeOfMatrix(arr,row, col);
		   
		   System.out.println("After transpose matrix -- ");
	        for (int i = 0; i < row; i++) {
	            for (int j = 0; j < col; j++) {
	                System.out.print(arr[i][j] + " ");
	            }
	            System.out.println();
	        }
		   
	    	for(int i = 0 ; i < row ; i++){
	    		getReverseOfArray(arr[i]);
	    	}
	    }


	    public static void getTransposeOfMatrix(int arr[][], int row, int col){

	    	for (int i = 0 ; i < row ; i++){
	    		for (int j = i ; j < col ; j++){
	    			int temp = arr[i][j];
	    			arr[i][j] = arr[j][i];
	    			arr[j][i] = temp;
	    		}
	    	}

	    }


	    public static void getReverseOfArray(int arr[]){
	    	
	    	for (int endInd = arr.length-1 ; endInd >=0 ; endInd--){
	    		int startIndex=0;
	    			int temp = arr[startIndex];
	    			arr[startIndex]=arr[endInd];
	    			arr[endInd]=temp;
	    			startIndex++;
	    			
	    	}
	    }

	    
	    
	    
	}

