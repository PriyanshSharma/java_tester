package com.practice;

import java.util.Arrays;

public class LuxoftEx {
public static void main(String[] args) {
	
	char[] arr1 = "tnow".toCharArray();
	char[] arr2 = "owns".toCharArray();
	
	Arrays.sort(arr1);
	Arrays.sort(arr2);
	boolean issame = true;
	for(int i = 0 ; i < arr1.length ; i++) {
		if(arr1.length!=arr2.length) {
			issame=false;
		}
		
		else {
			
			if(!(arr1[i]==arr2[i])) {
				issame=false;
				break;
			}
		}
	}
	
	System.out.println(issame);
}
}
