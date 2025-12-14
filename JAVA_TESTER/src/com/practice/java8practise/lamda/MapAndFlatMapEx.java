package com.practice.java8practise.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.practice.POJO.DepartMent;

public class MapAndFlatMapEx {

	public static void main(String[] args) {
		List<DepartMent> departList = Arrays.asList(new DepartMent(DepartMent.getDefaultDepartMent(), Arrays.asList("w1","w2","w3")),
				new DepartMent(DepartMent.getDefaultDepartMent(), Arrays.asList("w4","w5","w6")),
				new DepartMent(DepartMent.getDefaultDepartMent(), Arrays.asList("w9","w8","w7")),
				new DepartMent(DepartMent.getDefaultDepartMent(), Arrays.asList("w10","w12","w13")));
	
		

		//Get all the Worker Names for all department.
		
		
		
//		oldJava(departList);
//		mapExample(departList);
		flatMapExample(departList);
	}
	
	public static void  oldJava(List<DepartMent> departMentList) {
		
		//Get all the Worker Names for all department.
		
		// Old way before java 8
		
		for(DepartMent d : departMentList) {
			List<String> departWorkers =d.getDeptWorkerNames();
			System.out.print(d);

			for(String work:departWorkers) {
				System.out.println(work);
			}
		}
		
		
	}
	
	public static void mapExample(List<DepartMent> dList) {
		
		dList.stream().forEach(department-> {
			System.out.println(department);
			for(String s : department.getDeptWorkerNames()) {
				System.out.println(s);
			}
		});
	}
	
	public static void flatMapExample(List<DepartMent> dlist) {
		dlist.stream().flatMap(d-> {
			System.out.println(d);
			return d.getDeptWorkerNames().stream();
		}).forEach(System.out::println);
	}
}
