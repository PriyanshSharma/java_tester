package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.practice.POJO.Employee;



public class DataAccessUnBounded<T> {
	
	List<T> objList ;
	
	public DataAccessUnBounded () {
		objList = new ArrayList<T>();
	}
	private void displayAll() {
	for (T listOb : objList) {
		System.out.println("val at list -- "+listOb);
	}
	}
	public void popualteLsit (List<T> list) {
		this.objList = list;
		displayAll();
	}
		
	
	public void saveObj (T saverObej) {
			System.out.println("Value saved - "+saverObej);
	}
	public static void main(String[] args) {
	
	DataAccessUnBounded<Employee> dataEmp = new DataAccessUnBounded<Employee>();
	
	List<Employee> listEmp = Stream.of(new Employee (1, "A"),
										new Employee (2, "B"),
										new Employee(3, "C")).collect(Collectors.toList());
	Employee empSaver = new Employee(5, "Priyansh Saver");
	dataEmp.popualteLsit(listEmp);
	dataEmp.saveObj(empSaver);
	}
}
