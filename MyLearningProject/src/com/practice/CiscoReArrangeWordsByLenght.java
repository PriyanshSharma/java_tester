package com.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CiscoReArrangeWordsByLenght {
	
	public static void main(String[] args) {
		String input = "The lines are printed in reverse order.".toLowerCase().replace(".","");
		
		String[] strArr= input.split(" ");
		Arrays.sort(strArr, new Comparator<String>() {
			 
		      @Override
		      public int compare(final String s1, final String s2) {
		        return s1.length() < s2.length() ? -1 : 1;
		      }
		    });
		Character firstChar = strArr[0].charAt(0);
		strArr[0] = strArr[0].replaceFirst("^[a-z]", firstChar.toString().toUpperCase());
		
		String result =Stream.of(strArr).collect(Collectors.joining(" "))+".";
		System.out.println(result);
		
	}
	
}
