package com.practice.utility;

import java.util.Scanner;

public class InputfromConsole {

	public static String getInputFromConsole() {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		return input;
	}
}
