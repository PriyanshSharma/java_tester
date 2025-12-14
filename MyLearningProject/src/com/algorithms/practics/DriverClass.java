package com.algorithms.practics;

public class DriverClass {
	public static void main(String[] args) {
		try {
			System.out.println(dos(args));
		}catch (Exception e) {
			System.out.println("ëxc");
		}
		dos(args);
	}
	
	static int dos(String[] args) {
		
		return Integer.parseInt(args[0]);
	}
}
