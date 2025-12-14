package com.practice.java8practise.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExceptionHandlingUsingJava8 {

	
	public static void main(String[] args) {
		List <String> numberList = Arrays.asList("1","2","3","4","invalid");
		
		//Convert to int list
		
		List<Integer> intList = new ArrayList<Integer>();
//		numberList.stream().map(s-> Integer.valueOf(s)).collect(Collectors.toList());
//		intList.forEach(System.out::println);
		
		// o/p = Exception in thread "main" java.lang.NumberFormatException: For input string: "invalid"

		
		// Handle exception = 
		
		
		intList=		numberList.stream().map(s->{
			try {
				return Integer.valueOf(s);
			}catch (NumberFormatException e) {
				return 0;
			}
		}).collect(Collectors.toList());
		
		intList.forEach(System.out::println);


		// Another way - Create a wrapper function and use method reference
		intList = numberList.stream().map(ExceptionHandlingUsingJava8::getMyNumber).collect(Collectors.toList());
		System.out.println("Another way method wrapper = "+intList);
	
		// generic way -- 
		
		intList = numberList.stream().map(handleException(n->Integer.valueOf(n), 0)).collect(Collectors.toList());
		System.out.println(intList);
	
	}
	public static Integer getMyNumber(String s) {
		
		try {
			return Integer.valueOf(s);
		}catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;

		}
	}
	
	//More generic method for the same. -- 
	
	  public static <T, R> Function<T, R> handleException(Function<T, R> function, R defaultValue) {
	        return t -> {
	            try {
	            	System.out.println("Generic way.. ");
	                return function.apply(t);
	            } catch (Exception e) {
	                System.out.println("Exception caught: " + e.getMessage());
	                return defaultValue; // Return default value on exception
	            }
	        };
	    }
}
