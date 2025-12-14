package com.practice.DS;

public class BooyerMooreAlgoCountElementGreaterhalfofArraySize {
	public static void main(String[] args) {
		int arr[] = {5,3,1,2,3,54,1,54,1,1,1,1,1,1};
		int ansindex=0;
		int count=1;
		
		for(int i=1;i<arr.length;i++) {
			if(arr[ansindex]==arr[i]) {
				count++;
			}
			else {
				count --;
			}
			
			if(count==0) {
				ansindex=i;
				count=1;
			}
		}
		count=0;
		for (int i = 0 ; i < arr.length; i ++) {
			if(arr[ansindex]==arr[i]) {
				count ++;
			}
		}
		
		if (count>(arr.length/2)) {
			System.out.println(arr[ansindex]);
		}
		else {
			System.out.println("not found");
		}
	}

}
