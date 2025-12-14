package com.practice.java8practise.lamda;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import com.practice.POJO.Employee;

public class AllBiFuntionalInterfacesexample {
public static void main(String[] args) {
	biPredicate();
	
	/*
	 * Same like all the 3 funtional interfaces, there method takes 2 args, and return the same as they
	 * are returning before.
	 * There is no BiSupplier, because its methods takes no arg, is used to get the object
	 */
}
	
	public static void biPredicate() {
		
		
		//BiPredicate <FirstArg, Second Arg> = always return boolean -- test(FirstArg,secondArg)
		BiPredicate<Integer, Integer> biPred = (i1,i2)-> i1>i2;
		System.out.println(biPred.test(10, 100));
		
		List<Employee> empList = Employee.getEmployeeList();
	}
}
