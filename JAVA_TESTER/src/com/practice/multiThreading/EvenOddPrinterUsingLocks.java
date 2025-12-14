package com.practice.multiThreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOddPrinterUsingLocks {

	Lock lock = new ReentrantLock();
	Condition evenCondition = lock.newCondition();
	Condition oddCondition = lock.newCondition();
	
	public static int counter = 1;
	public  static final int MAX=20;
	
	public static void main(String[] args) {
		
		EvenOddPrinterUsingLocks obj  = new EvenOddPrinterUsingLocks();
		
		Thread evenThread = new Thread (obj::evenPrinter);
		Thread oddThread = new Thread (obj::oddPrinter);
		
		evenThread.start();
		oddThread.start();
		
		try {
			evenThread.join();
			oddThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public void evenPrinter () {
		
		while(counter<=MAX) {
			lock.lock();
			
			if(counter%2==1) {
				try {
					evenCondition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("Thread - Even "+counter++);
			oddCondition.signalAll();
			lock.unlock();
		}
	}
	

	
	
	public void oddPrinter () {
		
		while(counter<=MAX) {
			lock.lock();
			
			if(counter%2==0) {
				try {
					oddCondition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("Thread - Odd "+counter++);
			evenCondition.signalAll();
			lock.unlock();
		}
	}
}
