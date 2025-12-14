package com.practice;

public class ExceptionOutput {
	public static void main(String args[]) {
		try {
			try {
				System.out.println("Second Try block"); //1
				int b = 1000 / 0;
				System.out.println(b);
			} catch (ArithmeticException ex1) {
				System.out.println("First catch block"); //2
			}
			try {
				int []a = {1,2,3,4};
				System.out.println("Third try block"); //3
				int b = a[6];
				System.out.println(b);
			} catch (ArithmeticException ex2) {
				System.out.println("Second catch block");
			} finally {
				System.out.println("First finally block"); //4
			}
			System.out.println("First Try block");
		} catch (ArithmeticException ex3) {
			System.out.println("Arithmetic Exception");
			System.out.println("Third catch block");
		} catch (ArrayIndexOutOfBoundsException ex4) {
			System.out.println("ArrayIndexOutOfBoundsException"); //5
			System.out.println("Fourth catch block"); //6
		} catch (Exception ex5) {
			System.out.println("Exception");
			System.out.println("Fifth catch block");
		} finally {
			System.out.println("Second finally block"); //7
		}
		System.out.println("End of try catch finally block"); //8
	}
}
