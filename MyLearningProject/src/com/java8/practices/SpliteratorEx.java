package com.java8.practices;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorEx {

	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();
		
		stringList.add("Priyansh");

		stringList.add("Ruchi");

		stringList.add("KRiday");

		stringList.add("RAmu");

		stringList.add("Srishti");
		
		Spliterator<String> s1 = stringList.spliterator();
	
		System.out.println(s1.getExactSizeIfKnown());
		System.out.println(s1.estimateSize());
		s1.forEachRemaining(System.out::println);
		
		System.out.println(s1.getExactSizeIfKnown());
		System.out.println(s1.estimateSize());
		
		
		Spliterator<String> s2 = s1.trySplit();
//		Spliterator<String> s3 = s2.trySplit();
		s2.forEachRemaining(System.out::println);
		
		
	}
}
