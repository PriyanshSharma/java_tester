package com.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Imagine m items are to be distributed among people standing in a circle of size n (m < n). 
 * Starting from a given point, you distribute one item to every
 *  k-th person until all items are distributed. Who gets the last item?
 *  
 *  
 *  
 *  Producer- consumer
 */
public class TestSigMaTest {

	Queue<Integer> commonResource = new LinkedList<Integer>();
	

	
	public static void main(String[] args) {
		
		TestSigMaTest obj = new TestSigMaTest();
		ProducerClass producer = new ProducerClass(obj.commonResource, 10);
		ConsumerThread consumer = new ConsumerThread(obj.commonResource, 10);
		
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);
		
		
		t1.start();
		t2.start();

	}
}


class ProducerClass implements Runnable {

	Queue<Integer> commonResource ;
	int MAX_CAPACITY;
	int producereMessage=0;
	public ProducerClass(Queue<Integer> commonResource, int limit ) {
		
		this.commonResource = commonResource;
		this.MAX_CAPACITY = limit;
	}
	@Override
	public void run() {
		
		synchronized (this) {
			
			while (true) {
				
				if (this.commonResource.size()==this.MAX_CAPACITY) {
					System.out.println("Over flow .. Stop producing");
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				this.MAX_CAPACITY++;
				System.out.println("Producing message == "+producereMessage++);
				commonResource.add(producereMessage);
				
				this.notifyAll();
			}
			
		}
		
	}
	
}


class ConsumerThread implements Runnable{

	
	Queue<Integer> commonResource ;
	int MAX_CAPACITY;
	int producereMessage=0;
	
	public ConsumerThread(Queue<Integer> commonResource ,
	int MAX_CAPACITY) {
		this.commonResource = commonResource;
		this.MAX_CAPACITY = MAX_CAPACITY;
	}
	
	@Override
	public void run() {

		

		synchronized (this) {
			
			while (true) {
				
				if (this.commonResource.size()<0) {
					System.out.println("Under flow .. Stop Consuming");
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println("Consumed message == "+this.commonResource.poll());
				System.out.println("==========================================================================================================");
				this.MAX_CAPACITY--;
				
				this.notifyAll();
			}
			
		}
	}
	
}


