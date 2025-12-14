package com.practice;

public class Hello implements InterfA, InterfB{

	String name = "Ruchi";
	int age = 25;
	
	public Hello doPrint(String name, int age) {
		Hello h = new Hello();
		h.name = name;
		h.age = age;
		return h;
		
	}
	
	public static void main(String[] args) {
		Hello h1 = new Hello ();
		Hello h2 = new Hello ();
		
		System.out.println("Old val --- "+h1.name + "-"+h1.age);
		
		h2 = h1.doPrint("Priyansh", 27);
		
		System.out.println("New ----");
		System.out.println(h2.name + " - "+h2.age);
		
	}

	@Override
	public void addme() {
		// TODO Auto-generated method stub
		
	}
}
