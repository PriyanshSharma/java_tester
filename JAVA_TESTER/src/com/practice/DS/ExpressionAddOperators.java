package com.practice.DS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Given a string num that contains only digits and an integer target, 
 * return all possibilities to insert the binary operators '+', '-', and/or '*' 
 * between the digits of num so that the resultant expression evaluates to the target value.
 * Note that operands in the returned expressions should not contain leading zeros.

 

	Example 1:
	
	Input: num = "123", target = 6
	Output: ["1*2*3","1+2+3"]
	Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.
	Example 2:
	
	Input: num = "232", target = 8
	Output: ["2*3+2","2+3*2"]
	Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.
	Example 3:
	
	Input: num = "3456237490", target = 9191
	Output: []
	Explanation: There are no expressions that can be created from "3456237490" to evaluate to 9191.
 */
public class ExpressionAddOperators {

	
	public static void main(String[] args) {
//		List l =new ExpressionAddOperators().addOperators("105", 5);
//		System.out.println(l.toString());
		
		System.out.println(new ExpressionAddOperators().evaluateExpression("1-2-3"));
		
	}
	
	public List<String> addOperators(String num, int target) {
        
		List<String> result = new ArrayList<String>();
		num=num.replaceFirst("^0+(?!$)", "");
		char[] c = {'+','-','*'};
		int partPostiion=0;
		getAllExpressions(num,c,partPostiion,"",result,target);
		
		return result;
    }

	private void getAllExpressions(String num, char[] arr, int partPostiion, String s, List<String> result,int target) {

		if (partPostiion==num.length()-1) {
			String adder = s+num.charAt(partPostiion);
			int value = evaluateExpression(adder);
			if (value==target) {
				result.add(adder);
			}
			return;
			}
			
		for (int i = 0 ; i <arr.length ; i++ ) {
			
			String partString = num.substring(partPostiion,partPostiion+1);
			
			if (partPostiion!=num.length()-1){
				partString=partString+arr[i];
			}
			getAllExpressions(num, arr, partPostiion+1,s+partString, result,target);
		}
		
		
		
	}

	private int evaluateExpression(String adder) {
		Stack<Integer> operand = new Stack<Integer>();
		Stack<Character> operator = new Stack<Character>();
		
		int result=0;
		
		for (char ch: adder.toCharArray()) {
			if (Character.isDigit(ch) ) {
				operand.push(ch-'0');
			}
			else {
				if (operator.isEmpty()) {
					operator.push(ch);
				}
				else {
					char top = operator.peek();
					if (precedence(ch)>=precedence(top)) {
						operator.push(ch);
					}
					else {
						if (top=='+') {
							result = (int)operand.pop() + (int)operand.pop();
							operand.push(result);
						}else if (top=='-') {
							result = (int)operand.pop() - (int)operand.pop();
						}
						else {
							result = (int)operand.pop() *(int)operand.pop();
						}
						operand.push(result);
						operator.pop();
						operator.push(ch);
					}
				}
			}
		}
		
		
		while (!operator.isEmpty()) {
			char c1 = operator.pop();
			if (c1=='+') {
				result = (int)operand.pop() + (int)operand.pop();
			}else if (c1=='-') {
				result = (int)operand.pop() - (int)operand.pop();
			}else {
				result = (int)operand.pop() *(int)operand.pop();
			}
			
			operand.push(result);
		}
		return result;
	}
	
	private int precedence(char op) {
	    switch (op) {
	        case '+':
	        case '-':
	            return 1;
	        case '*':
	        case '/':
	            return 2;
	        default:
	            return 0;
	    }
	}
}











