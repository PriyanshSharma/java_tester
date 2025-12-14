package com.anujbhaiyaquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class GetAllUniPermutations {
	static List<String> allString = new ArrayList<String>();
	static ArrayList<ArrayList<Integer>> integerPermutations = new ArrayList<ArrayList<Integer>>();
	static ArrayList<String> tempList = new ArrayList();
	public static void main(String[] args) {
		String input = "abc";
		
		int l=0;
		int r=input.length()-1;
		List<Integer> intlist =  Arrays.asList(1,2,1);
		
				getPermutationsofString(input,l,r);
				getPermutationsofArray(intlist,0,intlist.size()-1);
	
				
		System.out.println(allString);
		for(String s : tempList) {
			
			System.out.println("Array elem - >"+s);
			
			ArrayList<Integer> myIntList = new ArrayList<Integer>();
			for(int i = 0 ; i < s.length() ; i ++) {
				myIntList = new ArrayList<Integer>();
				Integer s2= (int) s.charAt(i);
				myIntList.add(s2);
			}
			integerPermutations.add(myIntList);
		}
		
		for(int i = 0 ; i < integerPermutations.size(); i++) {
			
			for(int j = 0 ; j < intlist.size() ; j++) {
				System.out.print(integerPermutations.get(i).get(j)+" ");
			}
			System.out.println();
		}
//		System.out.println(integerPermutations);
	}
	private static void getPermutationsofArray(List<Integer> intlist, int l, int r) {
		if(l==r) {
			ArrayList<Integer> sortedArray = new ArrayList<Integer>(intlist);
			Collections.sort(sortedArray);
			StringBuffer s1 = new StringBuffer();
			for(int k : intlist) {
				s1.append(k);
			}
			String s = s1.toString();
			
			
			if(!tempList.contains(s)) {
				tempList.add(s);
				System.out.println(intlist);
			}
			return;
		}
		for(int i =  l; i <= r ; i ++) {
			intlist = swapme(intlist, l, i);
			getPermutationsofArray(intlist, l+1, r);
			intlist = swapme(intlist, l, i);
		}
	}
	private static void getPermutationsofString(String input, int l, int r) {
		if(l==r) {
			allString.add(input);
			return;
		}
		for(int i = l ; i <=r ; i++) {
			input = swapme(input, l, i);
			getPermutationsofString(input, l+1, r);
			input = swapme(input, l, i);
		}
	}
	
	private static String swapme(String input, int l, int r) {
		char[] charArr = input.toCharArray();
		
		char temp = charArr[l];
		charArr[l]=charArr[r];
		charArr[r]=temp;
		
		return new String(charArr);
	}
	
	private static List<Integer> swapme(List<Integer> input, int l, int r) {
		
		int temp =   input.get(l);
		input.set(l, input.get(r));
		input.set(r, temp);
		
		return input;
		
		
	}
}


