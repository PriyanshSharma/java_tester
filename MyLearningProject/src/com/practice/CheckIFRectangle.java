package com.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckIFRectangle {

	 public static int solve(int A, int B, int C, int D) {
	        Set<Integer> set = new HashSet<Integer>();
	        set.add(A);
	        set.add(B);
	        set.add(C);
	        set.add(D);
	        if(set.size()==2 || set.size()==1){
	            return 1;
	        }
	        else {
	            return 0;
	        }
	    }
	 public static void main(String[] args) {
		System.out.println(solve(5, 5, 4, 4));
		
		List<Integer> l = new ArrayList<Integer>();
		
	}
}
