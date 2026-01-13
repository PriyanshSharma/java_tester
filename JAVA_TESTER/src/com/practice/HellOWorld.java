package com.practice;

public class HellOWorld {
	 String s ;
	 int len = s.length();
	
	public HellOWorld(String s) {
		
		this.s=s;
	}
	
	public static void main(String[] args) {
		  // 1. String Literals
       
		HellOWorld  h = new HellOWorld("abc");
		
		System.out.println(h.len);
		
	}
	
	
}
