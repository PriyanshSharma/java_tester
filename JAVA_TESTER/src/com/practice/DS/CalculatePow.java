package com.practice.DS;

public class CalculatePow {

	
	public static void main(String[] args) {
		double ans =new CalculatePow().myPow(2.0, -200000000);
		System.out.println(ans);
	}
	 public double myPow(double x, int n) {
	        
	        if (n>0){
	            return helperpow(x,n);
	        }
	        else {
	            return helperpow(1/x,n*-1);
	        }
	        
	    }

	    private double helperpow(double x, int n ){

	    	 if (n == 0) return 1.0;

	         double half = helperpow(x, n / 2);

	         if (n % 2 == 0) {
	             return half * half;
	         } else {
	             return half * half * x;
	         }
	    }
}
