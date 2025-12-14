package com.practice.DS;

import java.util.ArrayList;
import java.util.List;

public class PascalTrianglre {

	public static void main(String[] args) {
		int n = 2;
		printValueAt(n, 4);
		printEntireRow(n+1);
		printCompletepascaltriangle(n);
		
	}
	
	private static void printValueAt(int row, int col) {
		// we use to calcuate by nCr, so here n<-row, r<-col
		// but there is a formula..... we use that instead of calculating the fact.
		
		int ans=1;
		
		for(int i = 0 ; i < col ; i++) {
			
			ans = ans*(row-i);
			ans = ans/(i+1);
		}
		
		System.out.println(ans);
		
		
	}
	
	private static void printEntireRow(int rowNum) {
		
		int ans =1;
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		for (int i = 1 ; i <rowNum ; i ++) {
			ans = ans * (rowNum-i);
			ans = ans/i;
			list.add(ans);
		}
		
		System.out.println(list);
	}
	private static void printCompletepascaltriangle(int rowNm) {
		for (int i = 0 ; i <=rowNm; i ++) {
			printEntireRow(i+1);
		}
	}
}
