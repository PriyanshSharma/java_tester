package com.practice.DS;

public class PrimeBetweenRange {

	public static void main(String[] args) {
		int n = 12;
		
		for (int i = 2; i<Math.sqrt(12);i++) {
			
			if(n%i==0)
			{
				System.out.println(i+" - Not prime");
			}
			else {
				System.out.println(i+" - Prime");
			}
		}
	}
}
