package com.practice;

import java.util.LinkedHashSet;
import java.util.stream.IntStream;

public class AltimetrikEx {

	public static void main(String[] args) {
		
		int[] arr = {100,0,6,-3,-4,1,200};
		
		int max = IntStream.of(arr).max().getAsInt();

		int min =IntStream.of(arr).min().getAsInt();
		
		
		/*
		 * String str = "&ca*a*begc#ds&11hjljsdfl33";
		 * 
		 * 
		 * output:
			Split special character from string : &**#&
			Output 1 - Print only the unique values : &*#
			Split alphabet from string caabegcds
			Output 2 - Print only the unique values : cabegds
			
			a=97
			z=a+25
		 */
		
		
//		String input = "&ca*a*begc#ds&879";
//		LinkedHashSet<String> characters = new LinkedHashSet<String>();
//		LinkedHashSet<String> specialChars = new LinkedHashSet<String>();
//		for(int i = 0 ; i < input.length() ; i ++) {
//			Character c = input.charAt(i);
//			if(c>=97 && c<=('a'+25)) {
//				characters.add(c.toString());
//			}
//			else  {
//				try {
//					Integer.parseInt(c.toString());
//					
//				}catch (NumberFormatException  e) {
//					specialChars.add(c.toString());
//				}
//				
//			}
//		}
//		characters.forEach(System.out::print);
		System.out.println(max);
		System.out.println(min);
//		specialChars.forEach(System.out::print);
	}
}
