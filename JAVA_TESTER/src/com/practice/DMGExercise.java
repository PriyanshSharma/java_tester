package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Write code to filter a list of object containing string, integer, long etc and return list of only even integer values.
public class DMGExercise {

	//List ={abc,123,123.0909,2,4,6,8,9}
	
	public static void main(String[] args) {
		List objectList = new ArrayList();
		objectList.add("Hello");
		objectList.add(2);
		objectList.add(4);
		objectList.add(3);
		objectList.add(2.12);
		objectList.add(null);
		
		List<Integer> intLisst =  (List<Integer>) objectList.stream().filter(o-> o instanceof Integer && (int)o%2==0).
				map(ob->(Integer)ob).collect(Collectors.toList());
		
		System.out.println(intLisst);
	}
	
	
	
	
	//Multiple APIs simultaneously using CompletableFuture and once you get the response send success
}
