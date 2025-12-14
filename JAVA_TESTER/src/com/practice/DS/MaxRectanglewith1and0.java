
package com.practice.DS;

import java.util.Arrays;

public class MaxRectanglewith1and0 {

	public static void main(String[] args) {
		
		int[][] matrix = {
	            {1, 0, 1, 1, 1},
	            {1, 0, 1, 1, 1},
	            {1, 1, 1, 1, 1},
	            {1, 0, 0, 1, 0}
	        };
	
	
	getMaxAreaReactangle(matrix);
	
	}

	private static void getMaxAreaReactangle(int[][] matrix) {
		int arr[] = new int [matrix[0].length];
		arr = matrix[0];
		
		int maxArea = MaxAreaOfHistogram.getMaxAreaHistoGram(arr);
		int colCount = matrix[0].length;
		int rowCount = matrix.length;
		int ans=0;
		for (int i = 1; i <rowCount ; i++) {
			for (int j = 0; j<colCount ; j++) {
				if(matrix[i][j]==1) {
					arr[j] = arr[j]+1;
				}
				else {
					arr[j]=0;
				}
			}
			int currans = MaxAreaOfHistogram.getMaxAreaHistoGram(arr);
			maxArea = Math.max(currans, maxArea);
			
		}
		
		System.out.println(maxArea);
	}
	
	
}
