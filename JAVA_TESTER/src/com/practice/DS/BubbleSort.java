package com.practice.DS;

import java.util.Arrays;

public class BubbleSort {
public static void main(String[] args) {
	int arr[] = {20,-15,35,7,55,1,-22};
	int index = arr.length-1;
	for (int i = index ; i >=0 ; i -- ) {
		for (int j = 0 ; j<i ; j++ ) {
			if(arr[j]>arr[j+1]) {
				 int temp = arr[j];
			        arr[j] = arr[j + 1];
			        arr[j + 1] = temp;
			}
		}
	}
	
	Arrays.stream(arr).forEach(System.out::println);
}
}
