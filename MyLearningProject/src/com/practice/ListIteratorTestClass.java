package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class ListIteratorTestClass {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer> ();
		
		for(int i =0 ;i<5; i++) {
			l.add(i);
			
		}
		
//		for(int i =0;i<l.size();i++) {
//			if(l.get(i)==3) {
//				l.remove(i);
//			}
//		}
		
//		HashMap<K, V>
//		System.out.println(l);
	ListIterator< Integer> itr = l.listIterator();
	System.out.println("Printing ");
	while(itr.hasNext()) {
		int next = itr.next();
		System.out.println(next);
		
		if(next==4) {
			l.remove(3);
		}
		itr.next();
	}
//	while(itr.hasPrevious()) {
//		System.out.println(itr.previous());
//	}
//	
	}
}
