package com.practice;

import java.math.BigDecimal;
import java.math.BigInteger;

public class PrintFibbonacciSeriesSum {

	static int n1=0,n2=1,n3=0,sum=0;
	public static void main(String[] args) {
//		sum= n1+n2;
//		System.out.println("N3---- "+n1);
//		System.out.println("N3---- "+n2);
//		System.out.println(printFiboSumRecursion(7-2));
		int count =0;
		count = 7;
		printFibboSumNoRecursion(count);
		count=11;
		printFibboSumNoRecursion(count);
		count=33;
		printFibboSumNoRecursion(count);
		count=50;
		printFibboSumNoRecursion(count);
//		printFibboSumNoRecursion(count-2);
		
		
	}
	
	

	public static void printFibboSumNoRecursion(int count) {
		int countrsum = count-2;
		int n1=0,n2=1,n3=0; double sum=1d;
		
		while(countrsum>0) {
			n3=n1+n2;
			n1=n2;
			n2=n3;
			sum = sum + n3;
//			System.out.println("N3---- "+n3);
			countrsum--;
		}
		System.out.println("Fibo for count -- "+count+" sume = "+sum);
		
		
	}
}
