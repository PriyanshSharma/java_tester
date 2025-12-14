package com.practice.DS;

public class FindAtoi {

	public static void main(String[] args) {
		String s = "4193 with words";
		int ans = new FindAtoi().myAtoi(s);
		System.out.println(ans);
	}
	
	public int myAtoi(String s) {
        s=s.trim();
        char sign = s.charAt(0);
        if (sign=='-' || sign =='+') {
        	s=s.substring(1);
        }
		int ans = helperAtoi(s,0,0);
		if (sign=='-') {
			ans = -1*ans;
		}
		
		return ans;
    }

	private int helperAtoi(String s, int i, int adder) {
		
		
		if ( s.length()==i || 
				(s.charAt(i) >= 65 && s.charAt(i) <= 90) || (s.charAt(i) >= 97 && s.charAt(i) <= 122) 
				|| (s.charAt(i)=='-') || (s.charAt(i)=='+') || (s.charAt(i)==' ') ) {
			return adder;
		}
		adder = adder*10 + s.charAt(i)-'0';
		return helperAtoi(s, i+1, adder);
	}
}
