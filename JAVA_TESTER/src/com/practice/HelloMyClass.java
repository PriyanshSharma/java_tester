package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class HelloMyClass {

	static int i =20;

	
	static {}
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		
		
		for (int i = 0 ; i <l.size() ; i ++) {
			System.out.println(l.get(i));
			if (i ==2) {
				l.remove(i);
			}
		}
		
		ListIterator<Integer> lit = l.listIterator();
		
		while (lit.hasNext()) {
			System.out.println(lit.next());
			lit.remove();
			l.remove(1);
			System.out.println(l);
			break;
		}


	}
	
	public static void m1 () {
		System.out.println("j = "+j);
	}
	
	static {
		//System.out.println("Second static...j=");
	}
	
	static int j = 30;

}

