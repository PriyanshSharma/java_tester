package com.algorithms.practics;

public class CollectZeroesAndOnes {

	public static void main(String[] args) {
		int[] arr = {0,1,1,1,0,0,1,1,1,0,0,1,0,0,0};
		int indexForOne =-1;
		for(int i = 0 ; i < arr.length ; i ++) {
			
			if(arr[i]==1) {
				indexForOne = i;
			}
			
		}
		
	}
}
