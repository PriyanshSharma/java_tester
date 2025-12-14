package com.practice;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Stream;

public class KthLargestElement {
public static void main(String[] args) {
	
	int[] arr = {12,34,65,1,49};
	String as  = "abc";
	Set<String> s = new HashSet<String>();
	s = new HashSet<String>();
	
	Stream.of(arr).filter(s1->as.equalsIgnoreCase(s1+""));
	
	int k = 4 ; // top 2 elements
	PriorityQueue<Integer> p = new PriorityQueue<Integer>();
	for(int i = 0 ; i < arr.length ; i ++) {
		if(i<k) {
			p.add(arr[i]);
		}
		
		else if(p.peek()<arr[i]) {
			p.remove();
			p.add(arr[i]);
		}
	}
//	Collections.sort(p);
System.out.println(p.peek());
}
}
