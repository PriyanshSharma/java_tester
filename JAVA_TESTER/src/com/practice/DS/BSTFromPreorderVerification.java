package com.practice.DS;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class BSTFromPreorderVerification {

	public static void main(String[] args) {
		int [] preOrder = {44,22,11,66,55,33,77,88};
		
		System.out.println(validateBSPFromPreOrder(preOrder));
	}

	private static boolean validateBSPFromPreOrder(int[] preOrder) {
		
		if(preOrder.length==0) {
			return false;
		}
		
		if(preOrder.length==1) {
			return true;
		}
		
		
		Stack<Integer> stack = new Stack<Integer>();
	
		int root=preOrder[0];
		for (int i = 0 ; i < preOrder.length; i++) {
			
			while (!stack.isEmpty() && preOrder[i]>stack.peek()) {
				root = stack.pop();
			}
			
			if(preOrder[i]<root) {
				return false;
			}
			stack.push(preOrder[i]);
		}
		Map<Integer,String> cacheMap = new LinkedHashMap<Integer, String>();
		Map.Entry<Integer, String> entry =   cacheMap.entrySet().iterator().next();
		entry.setValue("New Val");
		cacheMap.put(entry.getKey(), entry.getValue());
		cacheMap.remove(entry);
		
		return true;
	}
	
}
