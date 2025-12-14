package com.practice.java8practise.lamda;

public class AnonymousVsLamda {

	public static AnonymousInterface inter = new AnonymousInterface() {
		
		@Override
		public void sumMe(int a, int b) {
			System.out.println("Anoymous interace -- sum = "+(a+b));				
		}
		
		@Override
		public void printme() {
			System.out.println("This is printer .. Anonymous class.. ");
		}
	};
	
	
	public static void main(String[] args) {
		inter.sumMe(100, 200);
		inter.printme();
		
		FunctionalinterfaceEx lamdaEx = ()-> System.out.println("Funtional interface ex");
		lamdaEx.printerMethod();
	}
	
	public static void anonyMousClassEx() {
		
	}

}
