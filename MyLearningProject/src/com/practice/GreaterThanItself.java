package com.practice;

public class GreaterThanItself {
public static void main(String[] args) {
	
	int[] arr = {11,12,13,11,14,15,16,10,9,10,32,32,41,9,8};
	
	int max= 0;
	for(int i : arr) {
		if(i>max) {
			max=i;
		}
	}
	int count=0;
	for(int i : arr) {
		if(i<max) {
			count++;
		}
	}
	
	System.out.println(count);
}
}
