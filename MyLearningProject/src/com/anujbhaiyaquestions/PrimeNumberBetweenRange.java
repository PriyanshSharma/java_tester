package com.anujbhaiyaquestions;

import java.util.Arrays;

public class PrimeNumberBetweenRange {

	public static void main(String[] args) {
		
		int n =10;
		boolean boolArr[] = new boolean[n+1];
		
		Arrays.fill(boolArr, true);
		boolArr[1]=false;
		
		for(int i = 2 ; i*i<=n ; i++) {
			for(int j = 2*i ; j <=n ; j=j+i) {
				boolArr[j]=false;
			}
		}
		boolArr[2]=true;
		boolArr[3]=true;
		for(int i = 1 ; i < boolArr.length ; i++) {
			if(boolArr[i]) {
				System.out.println(i);
			}
		}
	}
}
