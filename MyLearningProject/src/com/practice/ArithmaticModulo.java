package com.practice;

public class ArithmaticModulo {
	public static void main(String[] args) {
		
		int a = 5 , b=5;
		
		calcPower(a,b);
	}

	private static void calcPower(int a, int b) {
		int res=1;
		while(b>0) {
			
			if((b&1)!=0) {
				res = res *a;
			}
			a=a*a;
			b=b>>1;
		}
		System.out.println(res);
		
	}
}
