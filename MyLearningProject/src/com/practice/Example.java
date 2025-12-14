package com.practice;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.*;

import bt.models.Employee;

public class Example {

	public static void main(String[] args) {
	
//	/// arrylist = random numbers ---
//		//triplet where sum is 8
//		
//		int arr[] = {0,1,2,3,5,7};
//		int sum =8;
//		int min = 0;//getMin(arr); =n
//		for(int i = 0 ; i < arr.length ; i ++) {
//			
//		}
//	
//		k = sum-(i+j)
//				8-(0,7)= ok
//				8-(1+5)=ok
//		if (set.contains(sum-i+j)) {
//			i,j, k
//			i++
//		}
//		else {
//			i++
//		}
		
		
		Map<Employee,String > s = new HashMap<Employee, String>();
		s.put(new Employee("1", "a", 0, "bc", null), "emp1");
		s.put(new Employee("13", "a", 0, "bc", null), "emp1 over");
		
		String s1 =s.get(new Employee("13", "a", 0, "bc", null));
		System.out.println(s.size());
		
		List<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		ListIterator<String> itr = l.listIterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//			itr.previous();
//		}

	Integer a = 10;
	Integer b =20;
	swap(a,b);
	System.out.println(a+" "+b);
	
	}

	private static void swap(Integer a, Integer b) {
		int temp ;
		temp=a;
		a=b;
		b=temp;
		
	}
}
