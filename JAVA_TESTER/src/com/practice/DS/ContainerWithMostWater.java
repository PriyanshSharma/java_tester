package com.practice.DS;

public class ContainerWithMostWater {
	public static void main(String[] args) {
		int arr[] = {1,8,6,2,5,4,8,3,7};
		System.out.println(new ContainerWithMostWater().getContainerWithMostWater(arr));
	}
	
	public int getContainerWithMostWater(int arr[]) {
		int maxAr = 0;
		int i = 0 ; 
		int j = arr.length-1;
		while (i<j) {
			int area ;
			if(arr[i]<arr[j]) {
				area = arr[i]*(j-i);
				i++;
			}else {
				area = arr[j]*(j-i);
				j--;
			}
			
			maxAr = Math.max(maxAr, area);
		}
		
		return maxAr;
	}
}
