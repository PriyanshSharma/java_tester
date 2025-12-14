package com.practice;

import java.util.HashMap;
import java.util.Map;

public class AmexDeckOfCards {
public static void main(String[] args) {
	
	String A = "A586QK";
	String B = "JJ653K";
	int result = solution(A,B);
	System.out.println(result);
}

private static int solution(String A, String B) {
	
	StringBuffer aliceWins = new StringBuffer();
	final Map<String, Integer> mapper = new HashMap<String, Integer>();
	mapper.put("2", 2);
	mapper.put("3", 3);
	mapper.put("4", 4);
	mapper.put("5", 5);
	mapper.put("6", 6);
	mapper.put("7", 7);
	mapper.put("8", 8);
	mapper.put("9", 9);
	mapper.put("T", 10);
	mapper.put("J", 11);
	mapper.put("Q", 12);
	mapper.put("K", 13);
	mapper.put("A", 14);
	
	
	for(int i = 0 ; i < A.length() ; i ++) {
		
		int alecVal = mapper.get(A.charAt(i)+"");
		int bobVal = mapper.get(B.charAt(i)+"");
		
		if(alecVal>bobVal) {
			aliceWins.append(1);
		}
	}
	
	return aliceWins.length();
}
}
