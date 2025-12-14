package com.algorithms.practics;


public class QueueArrayImplementation {
	
	
	int queue[];
	 int front=0;
	 int rear=-1;
	 
	 
	 public QueueArrayImplementation(int capacity) {
		 
		 queue= new int[capacity];
		 
	 }
	 
	 
	 
	public void addData(int data ) {
		
		if(rear ==queue.length-1) {
			System.out.println("Full capacity of Queue reached");
			return;
		}
		rear++;
		queue[rear] = data;
		
		
		
	}
	
	public int removeData () {
		
		if(front>=rear) {
			System.out.println("Empty array");
		}
		
		int frontVal = queue[front];
		queue[front]=0;
		front++;
		
		return frontVal;
	}
	
	public void printQueue() {
		
		for(int i = front ; i <=rear ; i ++) {
			
			System.out.println("Element --- at "+i+ " is "+queue[i]);
		}
	}
	 public static void main(String[] args) {
		QueueArrayImplementation queue = new QueueArrayImplementation(5);
		queue.addData(13);
		queue.addData(454);
		queue.addData(9743);
		queue.addData(34);
		
		
		queue.printQueue();
		
		
		queue.addData(676);
		
		
		System.out.println("After addd new elem ");
		
		queue.printQueue();
		
		queue.removeData();
		System.out.println("After remov elem ");
		queue.removeData();
		queue.printQueue();
		
		queue.addData(343);
	}
	}
