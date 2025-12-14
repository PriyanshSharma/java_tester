package com.practice;


import java.util.*;
public class DellRound2Ex {
	public static void main(String[] args) {
		String one = "dell";
		String two="lled";
		
		String[] arr = {"eat","cat","dog","tea","tac","tae"};
		
		MyPrinter p = new MyPrinter();
		
//		Thread a = new Thread(p);
		
//		Map<String,List<String>>
		
//		intputStr = arr[i]
////		sortedString = sort(inputStr);
//				if(map.contains(sortedString)) {
//					
//					map.get(SortedString).add(inputString);
//				}
//				
				
				
//		eateateateateateateateateateateateateateateateateateateateateateateateateateateateateateateateateateateateateateateateateateat
//		aaaaaaaaaaaaeeeeeeeeeeeeeeetttttttttttttttttttttttttttttttt
				
				// public String sort(String input){
				
				/*
				 * implement the logic for counting sort
				 */
//				return sortedString;
				//	}
	}
	
	
	}
class MyPrinter{
	
	
	
	void m1(){System.out.println("a");}
	

	void m2(){System.out.println("b");}
	

	void m3(){System.out.println("c");}

}



class MyThreadA extends Thread {
	MyPrinter p = null;
	public void run() {
		p.m1();
	}
	
	public MyThreadA(MyPrinter p ) {
		this.p=p;
	}
}

class MyThreadC extends Thread {
	MyPrinter p = null;
	public void run() {
		p.m3();
	}
	
	public MyThreadC(MyPrinter p ) {
		this.p=p;
	}
}

class MyThreadB extends Thread {
	MyPrinter p = null;
	public void run() {
		p.m2();
	}
	
	public MyThreadB(MyPrinter p ) {
		this.p=p;
	}
}




