package com.practice.DS;

import java.util.Arrays;

public class IntersectionArray {

	public static void main(String[] args) {
		int arr1[]= {10,20,30,2};
		int arr2[]= {2,3,4,10,20};
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int i=0;
		int j =0;
		
		while (i<arr1.length && j<arr2.length) {
			if(arr1[i]<arr2[j]) {
				i++;
			}
			else if (arr1[i]>arr2[j]) {
				j++;
			}
			else {
				System.out.println("Equals - "+arr1[i]);
				i++;j++;
			}
		}
	}
}
