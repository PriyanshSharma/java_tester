package com.algorithms.practics;

import java.util.EmptyStackException;

public class MyCustomStackArrayImplementation {

	int top =-1;
	
	int[] arr ;
	
	public MyCustomStackArrayImplementation(int capacity) {
		
		arr = new int[capacity];
	}
	
	
	public void pushData(int data) {
		
		if(top == arr.length) {
			throw new StackOverflowError();
		}
		
		arr[++top] = data;
	}
	
	
	public int popData() {
		if(top==-1) {
			throw new EmptyStackException();
		}
		
		return arr[top--];
	}
	
	
	public int peekData() {
		if(top==-1) {
			throw new EmptyStackException();
		}
		
		return arr[top];
		
	}
	public void printStack() {
		
		for(int i = top;i>=0;i--) {
			System.out.println(arr[i]);
		}
		
	}
	public static void main(String[] args) {
		MyCustomStackArrayImplementation stack = new MyCustomStackArrayImplementation(5);
		stack.pushData(1);
		stack.pushData(2);
		stack.pushData(3);
		stack.pushData(4);
		stack.pushData(5);
		stack.printStack();
	
		System.out.println("POPed----- "+stack.popData());
		stack.printStack();
		
		stack.pushData(10);
		System.out.println("Peek element --- "+stack.peekData());
		stack.printStack();
		
		
	}
}
