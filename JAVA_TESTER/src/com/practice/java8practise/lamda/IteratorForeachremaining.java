package com.practice.java8practise.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorForeachremaining {

	public static void main(String[] args) {
		List<String> slit = Arrays.asList("Priyanhs","ruchi","Hello Strign");
		Iterator<String> itr =  slit.iterator();
		System.out.println(itr.next());
		
//		itr.forEachRemaining(s-> {
//			System.out.println("printing next elements--"+s);
//		});
		
//		equivalent while loop 
		
		while (itr.hasNext()) {
			System.out.println("printing next elements while loop --"+itr.next());

		}
	}
}
