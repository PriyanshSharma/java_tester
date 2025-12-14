package com.practice.multiThreading;

import java.util.concurrent.CompletableFuture;

public class EvenOddPrinterUsingCompletableFuture {

	
	public static int counter =1;
	public static final int MAX=20;
	
	public static void main(String[] args) {
		
		EvenOddPrinterUsingCompletableFuture pritnerObj = new EvenOddPrinterUsingCompletableFuture();
		
		CompletableFuture<Void> evenPrinter = CompletableFuture.runAsync(pritnerObj::evenPrinter);
		CompletableFuture<Void> oddPrinter = CompletableFuture.runAsync(pritnerObj::oddPrinter);

		CompletableFuture.allOf(evenPrinter,oddPrinter).join();
		
	}
	
	
	public void evenPrinter() {
		
		while (counter<=MAX) {
			synchronized (this) {
				if(counter%2==1) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println("Thread - "+Thread.currentThread().getName()+" "+counter++);
				this.notifyAll();
			}
		}
	}
	
	public void oddPrinter() {
		
		while (counter<=MAX) {
			synchronized (this) {
				if(counter%2==0) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println("Thread - "+Thread.currentThread().getName()+" "+counter++);
				this.notifyAll();
			}
		}
	}
}
