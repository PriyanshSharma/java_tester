package com.practice.java8practise.lamda;

public class InterfacerExampleImpl  {

	InterfacerExample interfacer = new InterfacerExample() {
		
		@Override
		public void runMyMethod() {

			System.out.println("Any method");
		}
		
		@Override
		public String helloPrint() {
			// TODO Auto-generated method stub
			return "Hello";
		}
	};
	
	public void printMe () {
		System.out.println(interfacer.helloPrint());
		
	}
	
	public static void main(String[] args) {
		InterfacerExampleImpl ob = new InterfacerExampleImpl();
		
		ob.printMe();
	}
}
 