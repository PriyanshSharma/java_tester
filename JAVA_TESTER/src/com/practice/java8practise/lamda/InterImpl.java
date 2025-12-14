package com.practice.java8practise.lamda;

public class InterImpl {
public static void main(String[] args) {
	SummerInterface s = (a,b)-> a+b;
	
	SummerInterface sA = new SummerInterface() {
		
		@Override
		public int sumeMe(int a, int b) {
			// TODO Auto-generated method stub
			return a+b;
		}
	};
	
	System.out.println(s.sumeMe(10, 20));
	
	ZeroArgInterface z = ()-> System.err.println("Zero arg . . . ");
	z.printSome();
}
}
