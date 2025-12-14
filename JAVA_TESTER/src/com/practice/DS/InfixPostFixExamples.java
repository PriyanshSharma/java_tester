package com.practice.DS;

import java.nio.file.StandardWatchEventKinds;
import java.util.Stack;

public class InfixPostFixExamples {

	public static void main(String[] args) {
		String s = "A+B*C-(D/E)";
		convertInfixToPostFix(s);
	}
	
	public static void convertInfixToPostFix(String s) {
		/*
		 * Algo -- 
		 * if ( --> push to stack
		 * if operand --> print
		 * if ) --> pop stack and print till I get (
		 * if operator -->
		 * 			Pop from the stack while the top has higher or equal precedence, 
		 * 				then push the current operator
		 * 			else push to stack
		 * if expresion completed --> pop all the print.
		 */
		
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0 ; i < s.length() ; i ++) {
			
			
			
			if(s.charAt(i)=='(') {
				stack.push(s.charAt(i));
			}
			else if (s.charAt(i)==')') {
				while (!stack.isEmpty() && stack.peek()!='(')
				{
					System.out.println(stack.pop());
				}
				stack.pop();
			}else if (Character.isLetter(s.charAt(i))) {
				System.out.println(s.charAt(i));
			}
			
			else {
				while (!stack.isEmpty() && precedence(stack.peek())>=precedence(s.charAt(i))) {
					char popper = stack.pop();
					System.out.println(popper);
				}
				stack.push(s.charAt(i));
			}
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
	public static int precedence (char c) {
		
		if(c=='+' || c=='-') {
			return 1;
		}
		else if (c=='/' || c=='*') {
			return 2;
		}else {
			return -1;
		}
	}
}
