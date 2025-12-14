package com.practice;


import java.util.*;

public class Amazonex {
public static void main(String[] args) {
	List<List<String>> list = new ArrayList<List<String>>();
	
	Queue<String> insertedvals = new ArrayDeque<String>();
	
	List<String> insertAndShip = new ArrayList<String>();
	insertAndShip.add("INSERT");
	insertAndShip.add("GTC413");
	
	list.add(insertAndShip);
	
	insertAndShip = new ArrayList<String>();
	insertAndShip.add("INSERT");
	insertAndShip.add("TQC340");
	
	
	list.add(insertAndShip);
	
	
	insertAndShip = new ArrayList<String>();
	insertAndShip.add("SHIP");
	insertAndShip.add("-");
	

	list.add(insertAndShip);
	
	insertAndShip = new ArrayList<String>();
	insertAndShip.add("INSERT");
	insertAndShip.add("VYP991");
	

	list.add(insertAndShip);
	
	insertAndShip = new ArrayList<String>();
	insertAndShip.add("SHIP");
	insertAndShip.add("-");
	

	list.add(insertAndShip);

//	System.out.println(list);
	
	
	
	List<List<String>> completedAnswers = new ArrayList<List<String>>();
	
	
	for(List<String> query : list) {
		List<String> answers = new ArrayList<String>();
		if(query.get(0).equalsIgnoreCase("insert")) {
			
			insertedvals.add(query.get(1));
		}
		else {
			
			if(insertedvals.size()>=3) {
				answers.add(insertedvals.poll());
				answers.add(insertedvals.poll());
				answers.add(insertedvals.poll());
				
			}
			else {
				answers.add("N/A");
				
			}
			
			completedAnswers.add(answers);
		}
		
	}

	System.out.println(completedAnswers);
}

}
