package com.algorithms.practics;

public class PrefixMinOfArray {

	
	public static void main(String[] args) {
		int arr[] = {3,1,4,8,7,2,5};
		
		getPrefixMin(arr);
		
	
				
	}
	
	public static int[] getPrefixMin(int [] arr){
		int prefixMin[] = new int[arr.length];
		
		prefixMin[0] = arr[0];
		
		for(int i = 1 ; i < arr.length ; i++) {
			if(prefixMin[i-1]>arr[i]) {
				prefixMin[i]=arr[i];
			}
			else {
				prefixMin[i]=prefixMin[i-1];
			}
		}
		
		return prefixMin;
	}
}
