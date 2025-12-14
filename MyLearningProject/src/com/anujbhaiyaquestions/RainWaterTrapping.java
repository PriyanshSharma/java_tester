package com.anujbhaiyaquestions;

public class RainWaterTrapping {
	
	public static void main(String[] args) {
		int arr[] = {3,1,2,4,0,1,3,2};
		int prefixMax[] = new int[arr.length];
		prefixMax[0]=arr[0];
		
		int maxTrap = 0;
		
		int suffixMax[] = new int [arr.length];
		suffixMax[arr.length-1]=arr[arr.length-1];
		for(int i =1; i < arr.length ; i ++) {
			int max = Math.max(arr[i], prefixMax[i-1]);
			prefixMax[i]=max;
		}
		
		for(int i = arr.length-2; i >= 0 ; i --) {
			int max =Math.max(suffixMax[i+1],arr[i]);
			suffixMax[i]=max;
		}
		
		for(int i = 0 ; i <arr.length ; i++) {
			int min= (Math.min(prefixMax[i], suffixMax[i]));
			min = min - arr[i];
			maxTrap +=min;
		}
		System.out.println(maxTrap);
	}
}
