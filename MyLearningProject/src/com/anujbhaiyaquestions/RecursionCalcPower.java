package com.anujbhaiyaquestions;

public class RecursionCalcPower {

	public static void main(String[] args) {
		int a=5; 
		int pow = 4;
		
		
		int value = calcPower(a,pow);
		System.out.println(value);
	}

	private static int calcPower(int a, int pow) {
		
		if(pow==0) {
			
			return 1;
		}
		
		return a*calcPower(a, pow-1);
		
	}
}
