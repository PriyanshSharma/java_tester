package com.anujbhaiyaquestions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AllSubSetOfString {

	static List<String> subsetStringList = new ArrayList<String>();
	static List<Character[]> subsetString = new ArrayList<>();

	final static int sumValue = 3;
	
	public static void main(String[] args) {
		
		String input = "abc";
		
		String current = "";
		int i =0;
		
		calcSubSets(input,i,current);
//		System.out.println(subsetStringList);
//		
////		calcSubSetsForGivenSum(input, i, current);
//		System.out.println(subsetStringList);
	}

	/*
	 * private static void calcSubSetsForGivenSum(String input, int i, String
	 * current) { if(i==input.length()-1) { // if(current!="") { // String[] arr =
	 * current.split(""); // if
	 * (sumValue==Stream.of(arr).collect(Collectors.summingInt(val->Integer.parseInt
	 *
	 * subsetStringList.add(Stream.of(arr).collect(Collectors.joining("-"))); // //
	 * } // }
	 * 
	 * // subsetStringList.add(current); System.out.println(current); return; }
	 * 
	 * calcSubSetsForGivenSum(input, i+1, current+input.charAt(i));
	 * calcSubSetsForGivenSum(input, i+1, current);
	 * 
	 * }
	 */

	private static void calcSubSets(String input, int i, String current) {

		if(i==input.length()-1) {
//			if(current!="") {
//				if (sumValue==Stream.of(current.split("")).collect(Collectors.summingInt(val->Integer.parseInt(val))).intValue()) {
//					subsetStringList.add(current);
//				}
//			}
			System.out.println(current);
			return;
		}
		
		calcSubSets(input, i+1, current+input.charAt(i));
		calcSubSets(input, i+1, current);
	}
}
