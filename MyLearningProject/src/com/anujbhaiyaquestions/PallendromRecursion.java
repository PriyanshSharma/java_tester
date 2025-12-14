package com.anujbhaiyaquestions;

public class PallendromRecursion {
public static void main(String[] args) {
	
	String input = "madam";
	
	System.out.println(pallendrom(input,0,input.length()-1));
}

private static boolean pallendrom(String s, int l , int r) {
	// TODO Auto-generated method stub
	
	if(l>=r) {
		return true;
	}
	
	if(s.charAt(l)==s.charAt(r)) {
		return pallendrom(s, l+1, r-1);
	}
	return false;
}
}
