package com.practice;

import java.util.ArrayList;
import java.util.List;

public class GenericsBoundedEx {

	
	public void popualtevalues (List<? extends Number> numberList) {
		System.out.println(numberList);
	}
	public static void main(String[] args) {
		GenericsBoundedEx ex = new GenericsBoundedEx();
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(10);
		intList.add(20);
		intList.add(30);
		
		
		List <Float> floatList = new ArrayList<Float>();
		floatList.add(10.434f);
		floatList.add(1340.434f);

		floatList.add(90010.434f);

		
		ex.popualtevalues(intList);
		ex.popualtevalues(floatList);
		
		List<Number> numList = new ArrayList<Number>();
		numList.add(10.00);
		numList.add(200.90909);
		
		ex.popualtevalues(numList);
		
		List <String> stringList = new ArrayList<String>();
		stringList.add("ada");
		stringList.add("werewr");
		
//		ex.popualtevalues(stringList);

	}
}


