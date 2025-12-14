package com.practice.DS;

public class RainWaterTrap {
public static void main(String[] args) {
	int a[] = {3,1,2,4,0,1,3,2};
	int ans = 0 ;
	int left [] = new int[a.length];
	int r[] = new int [a.length];
	left[0]=a[0];
	r[a.length-1]=a[a.length-1];
	
	
	//populate left -\
	for (int i = 0 ; i < a.length-1 ; i ++) {
		left [i+1]=Math.max(left[i], a[i+1]);
	}
	
	//populate right
	
	for (int i = a.length-2; i >=0; i --) {
		r[i] = Math.max(r[i+1], a[i]);
	}
	
	for ( int i = 0 ; i < a.length ; i ++ ) {
		ans=  ans + (Math.min(left[i], r[i]) - a[i]);
	}
	System.err.println(ans);
}
}
