package com.practice;

public class InterfARunnerClass {
	
	public void printme(int a, int b) {
		
		System.out.println("both ints");
	}
	
	public void printme(int a, long b) {
		System.out.println("int and long");
	}
	
	public static void main(String[] args) {
		InterfARunnerClass a = new InterfARunnerClass();
		
//		a.printme(10l, 12l);
	}
}
