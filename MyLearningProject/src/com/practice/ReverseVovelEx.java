package com.practice;

import java.util.*;


public class ReverseVovelEx {
public static void main(String[] args) {
	List<String> vovels = Arrays.asList("a","e","i","o","u");
	
	String input = "hello";
	//eo --> oe
	StringBuffer vovelbuffer = new StringBuffer();
	
	for(int i = 0 ; i < input.length() ; i ++) {
		if(vovels.contains(input.charAt(i)+"")) {
			vovelbuffer.append(input.charAt(i));
		}
		
	}
	
	String reverse = vovelbuffer.reverse().toString();
	int count=0;
	char[] charArr = input.toCharArray();
	for(int i = 0 ; i < charArr.length ; i ++) {
		
		if(vovels.contains(charArr[i]+"")) {
			charArr[i] = reverse.charAt(count);
			count++;
		}
	}
	
	System.out.println(new String(charArr));
}
}
