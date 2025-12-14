package com.practice;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExampleMorgan {

	Queue<Integer> resource = new LinkedList<Integer>();
	
	final static int MAX=10;
	
	static int counter=0;
	
	public static void main(String[] args) {
		
		
		ProducerConsumerExampleMorgan object = new ProducerConsumerExampleMorgan();
		
		Runnable prodThread = new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println("Producing .. ");
				
				synchronized (this) {
					while (true) {
						if (object.resource.size()>MAX) {
							try {
								System.out.println("Overfloww..");
								this.wait();
								
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("Producing -- "+counter++);
							object.resource.offer(counter);
							this.notifyAll();
							
					}
					}
					
					
				}
					
			}
			
		};
		
		
		
		Runnable consumeThread = new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println("Consuming .. ");
				
				
				synchronized (this) {
					while (true) {
						if (object.resource.size()<0) {
							try {
								this.wait();
								System.out.println("Underflow..");
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						int i = object.resource.poll();
						
						System.out.println("Consumed -- "+i);
						this.notifyAll();
					}
					
					
					
				}
				
				
			}
		};
		
		
		Thread prod = new Thread(prodThread);
		Thread con = new Thread(consumeThread);
		
		
		
		prod.start();
		con.start();
	}
	
	
	
	
	
}



