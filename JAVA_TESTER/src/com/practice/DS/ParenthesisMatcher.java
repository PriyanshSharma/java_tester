package com.practice.DS;

import java.util.Stack;

public class ParenthesisMatcher {

	public static void main(String[] args) {
		String s = "()([])[][]([])[{{}]";
		Stack <Character> stack = new Stack<>();
		boolean flag =true;
		for (int i = 0 ; i < s.length() ; i ++) {
			
			if(isOpening (s.charAt(i))) {
				stack.add(s.charAt(i));
			}
			// - In case of closing bracket -- 
			else {
				if (stack.isEmpty()) {
					flag=false;
				}
				else if (isMatching (stack.peek(),s.charAt(i))) {
					stack.pop();
				}
				else {
					flag=false;
				}
			}
				
		}
	//	flag=stack.size()==0?true:false;
		System.out.println(flag);
	}

	private static boolean isMatching(Character peek, char charAt) {
		// TODO Auto-generated method stub
		return (peek=='(' && charAt==')') || (peek=='{' && charAt=='}') || (peek=='[' && charAt==']');
	}

	private static boolean isOpening(char charAt) {
		// TODO Auto-generated method stub
		
		return charAt=='(' || charAt=='{' || charAt=='[';
	}
}
