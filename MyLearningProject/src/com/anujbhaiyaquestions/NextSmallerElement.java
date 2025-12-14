package com.anujbhaiyaquestions;

import java.util.Stack;


/// same as previous smaller element - But start from reverse.....
public class NextSmallerElement {
public static void main(String[] args) {

 	int arr[] = {3,10,5,1,15,10,7,6};
	int resultArr[] = new int[arr.length];
 	Stack<Integer> stack = new Stack<>();
	for(int i = arr.length-1 ; i >=0 ; i--) {
		
		while (!stack.isEmpty() && arr[i]<= stack.peek()) {
			stack.pop();
		}
		
		if(stack.isEmpty()) {
			resultArr[i]=-1;
//			System.out.println(-1);
		}
		else {
			resultArr[i]=stack.peek();
//			System.out.println(stack.peek());
		}
		stack.push(arr[i]);
	}
	for (int ele : resultArr) {
		System.out.println(ele);
	}
}
}
