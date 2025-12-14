package com.practice.DS;

public class BuySellMaximiseProfitByMultipleSelling {

	public static void main(String[] args) {
		int arr[]= {5,2,6,1,4,7,3,6};
		int max=0;
		for(int i =1; i < arr.length ; i ++) {
			
			if(arr[i]>arr[i-1]) {
				max+= arr[i]-arr[i-1];
			}
		}
		
		System.out.println(max);
	}
}
