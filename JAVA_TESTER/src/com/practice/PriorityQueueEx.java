package com.practice;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueEx {
public static void main(String[] args) {
	
	Queue<Integer> q = new LinkedList<Integer>();
	q.add(10);
	q.add(20);
	q.add(130);
	q.add(15);
	q.add(188);
	q.add(100);
	q.add(3440);
	
	System.out.println(q);
	
	PriorityQueue<Integer> q1 = new PriorityQueue<Integer>();
	
	q1.add(10);
	q1.add(20);
	q1.add(130);
	q1.add(15);
	q1.add(188);
	q1.add(100);
	q1.add(3440);
	
	System.out.println("P Q = "+q);
	

}
}
