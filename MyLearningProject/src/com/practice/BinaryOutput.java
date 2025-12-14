package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryOutput {
public static void main(String[] args) throws Exception {

	int input =3;
	
	int totalArraySize=5;
	
	List<String> binaryArray = new ArrayList<String>(); 
	Scanner in = new Scanner(System.in);
	for(int i = 0 ; i < totalArraySize ; i ++) {
		String s = in.next();
		if(s.length()!=input) {
			throw new Exception("INcorrect input lenght");
		}
		binaryArray.add(s);
	}
	int countString=binaryArray.size();
	for(String s : binaryArray) {
		for(int i = 0 ; i< s.length()-1 ; i ++) {
			if(s.charAt(i)==1 && (s.charAt(i)==s.charAt(i+1)) ) {
				countString--;
				break;
			}
		}
	}
	System.out.println(countString);
}
}
