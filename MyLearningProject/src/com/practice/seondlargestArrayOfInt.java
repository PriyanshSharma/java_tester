package com.practice;

public class seondlargestArrayOfInt {
	
	public static void main(String[] args) {
		
		int arr[] = {13,56,13,89,565,92,100,600,520,600,565,13};
		int max = arr[0];
		int secmax=0;
		for(int i = 1 ; i <arr.length ; i++) {
			if(arr[i]>max) {
				secmax=max;
				max=arr[i];
			}
			if(arr[i]>secmax && arr[i]<max) {
				secmax=arr[i];
			}
//			else if (arr[i]>secmax && secmax<max) {
//				secmax = arr[i];
//				
//			}
		}
		System.out.println(secmax);
		
	}
}
