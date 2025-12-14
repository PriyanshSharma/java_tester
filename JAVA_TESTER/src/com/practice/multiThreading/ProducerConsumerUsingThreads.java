package com.practice.multiThreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerUsingThreads {

	public static void main(String[] args) {
		Queue<Integer> resource = new LinkedList<Integer>();
		int max =3;

		Runnable prod = new Runnable() {
			
			@Override
			public void run() {
				int value =1;

				System.out.println("Producer thread . . initialise value =1");
				while (true) {
				
					synchronized (resource) {
						if (resource.size()==1) {
							try {
//								System.out.println("Max size reached");
								resource.wait();
							} catch (InterruptedException e) {
//								System.out.println("I E exception");
								e.printStackTrace();
							}
						}
						System.out.println("Producing value...= "+value);
						resource.add(value++);
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						resource.notifyAll();
						
					}
					
				}
			}
		};
		
		
		Runnable consumeThread = new Runnable() {
			
			@Override
			public void run() {

				while (true) {
//					System.out.println("Consumer thread. . . ");
					synchronized (resource) {
					
						if(resource.isEmpty()) {
//							System.out.println("Resource empty now.. ");
							try {
								resource.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						System.out.println("Started consumer thread --- Consumed --  "+resource.remove());
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						resource.notifyAll();
					}
				}
			}
		};
		
		
		System.out.println("Starting producer and consumer..");
		new Thread(prod).start();
		new Thread(consumeThread).start();
	}
}
