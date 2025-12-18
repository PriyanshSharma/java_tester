package com.practice;

import java.util.Arrays;

public class WalmartPractice {

	
	//[1, 2, 2, 2, 3, 4, 5, 5, 6] -> [1, 2, 2, 3,4,5,5,6,_]
	//[1, 1, 1, 3, 3, 6, 6, 6, 6] -> [1, 1, 3, 3, 6, 6,_, _, _]
	// atmost 2
	public static void main(String[] args) {
		//O(n) - TC
		//O(1) - SC
		
		int arr []= {1, 2, 2, 2, 3, 4, 5, 5, 6};
		
		atmostKDuplicates(arr);
		
		System.out.println(Arrays.toString(arr));
		
		//[1, 2, 2, 3, 3, 4, 5, 6, 6]

	}

	private static void atmostKDuplicates(int[] arr) {
		
		
		//slow pointer
		int j = 0 ; 
		int maxAllowedDuplicate =0;
		
		//{1, 2, 2, 2-3, 3, 4, 5, 5, 6}
		                 
		
		for (int i =1 ; i<arr.length ; i++) {
			
			if (maxAllowedDuplicate>0 &&  arr[i]!=arr[j]) {
				j++;
				arr[j]=arr[i];
				maxAllowedDuplicate=0;
				
			}
			else if (arr[j]==arr[i]){
				
				maxAllowedDuplicate++;
			}
			
			j++;
		}
		
	}
}
