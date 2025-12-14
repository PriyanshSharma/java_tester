package com.practice;




/*
 * Days: 1,2,3,4,5
 * Share value: 10, 9, 2, 5, 1
 */
public class SocieteGeneralRound2 {
	
	
	public static void main(String[] args) {
		
		int arr[] = {10, 9, 1, 2, 5};
		
		int min = arr[0];
		int max = arr[1]-min;
		
		for(int i =1 ; i < arr.length ; i++) {
			
			if(arr[i]-min>max) {
				max = arr[i]-min;
			}
			if(min>arr[i]) {
				min = arr[i];
			}
		}
		System.out.println(max);
	}
	
}
