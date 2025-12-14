package com.practice;

import java.util.ArrayList;
import java.util.List;

public class Parent {

	public static void doStuff(Parent p) {
		p.printclass();
	}
	
	public void printclass() {
		System.out.println("Parent class");
	}
	
	
	public static void main(String[] args) {
		
		Parent p = new Chiild();
		Parent p1 = new Parent();
		Chiild c = new Chiild();
		
//		doStuff(p);
//		doStuff(p1);
//		doStuff(c);
		
		//p.printClassChildVersion();
		
		List<String> l = new ArrayList<String>();
//		l.e
//		ArrayList<String> al = new ArrayList<String>();
//		al.ensureCapacity(minCapacity);
	}
}

class Chiild extends Parent{
	public void printclass() {
		System.out.println("Child class");
	}
	
	public void printClassChildVersion() {
		System.out.println("Xtra method child");
	}
}
