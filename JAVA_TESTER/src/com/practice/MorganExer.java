package com.practice;

import java.util.Arrays;

public class MorganExer {

	
	// input = 2,0,3,0,1 = 0 2 3 0 1
	
		
	//, o/p = 0,0,2,3,1
	
	public static void main(String[] args) {
		
		int n =10;
		boolean arr[] = new boolean[n+1];
		Arrays.fill(arr, true);
		arr[0]=false;
		arr[1]=false;
		
		
		// i<=sqrt(n) == i*i<=n
		
		for (int i =2 ; i<=n ; i++) {
			
			if (arr[i]==true) {
				
				for ( int j = i*i ; j<=n ; j =j+i ) {
					arr[j]=false;
				}
			}
		}
		
		for (int i = 2 ; i <= n ; i ++) {
			
			if (arr[i]==true) {
				System.out.println("Prime - "+i);
			}
		}
	
	}
	
	
}
