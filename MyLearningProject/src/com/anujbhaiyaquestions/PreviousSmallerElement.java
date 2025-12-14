package com.anujbhaiyaquestions;

import java.util.Stack;

public class PreviousSmallerElement {	
	public static void main(String[] args) {
		int arr[] = {4,10,5,8,20,15,3,12};
		Stack<Integer> stack = new Stack<>();
		for(int i = 0 ; i < arr.length ; i ++) {
			
			
			while(!stack.isEmpty() && arr[i]<=stack.peek()) {
				stack.pop();
			}
			
			
			if(stack.isEmpty()) {
				System.out.println(-1);
			}
			else {
				System.out.println(stack.peek());
			}
				
			stack.push(arr[i]);
			
		}
	}
}
