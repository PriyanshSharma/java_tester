package com.practice;

import java.util.Arrays;

public class StandardChartered {

	public static void seggregate() {
		int arr[] = {10,2,4,6,8,1,5,3,5,6,7,9,3,2,4,4};
		
		int l =0 ; 
		int r = arr.length-1;
		
			while (l<r) {
				while (l<r && arr[l]%2==1) {
					l++;
				}
				while (l<r && arr[r]%2==0) {
					r--;
				}
				
				if(l<r) {
					swap(arr, l, r);
				}
			}
		
		System.out.println(Arrays.toString(arr));
	}
	
	private static void swap (int arr[], int l , int r) {
		int temp = arr[l];
		arr[l]=arr[r];
		arr[r]=temp;
	}
	
	public static void main(String[] args) {
		seggregate();
	}
}
