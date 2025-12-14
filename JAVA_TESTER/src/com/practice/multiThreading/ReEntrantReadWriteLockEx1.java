package com.practice.multiThreading;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReEntrantReadWriteLockEx1 {

	static int counter = 0 ;
	static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	public static void main(String[] args) {
		
		
		
		Runnable readerThread = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0 ; i < 10 ; i ++) {
					readCounter();
				}
				
				
			}
		};
		
		Runnable writerThread = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0 ; i < 10 ; i ++) {
					writeCounter();
				}				
			}
		};
		
		
		Thread r1 = new Thread(readerThread);

		Thread r2 = new Thread(readerThread);

		Thread r3 = new Thread(readerThread);
		

		Thread w1 = new Thread(writerThread);
		Thread w2 = new Thread(writerThread);
		
		w1.setName("w1");
		w2.setName("w2");
		
		r1.setName("r1");
		r2.setName("r2");
		r3.setName("r3");
		
		r1.start();
		r2.start();
		r3.start();
		w1.start();
		w2.start();
	}
	
	public static void writeCounter() {
		try {
			lock.writeLock().lock();
			counter++;
			System.out.println("Writing value == "+counter+" by Thread == "+Thread.currentThread().getName());
			
		}finally {
			lock.writeLock().unlock();
		}
		
	}
	
	public static void readCounter() {
		
		try{lock.readLock().lock();
		System.err.println("Reading value == "+counter+" by Thread == "+Thread.currentThread().getName());
		}finally {
			lock.readLock().unlock();
		}
	}
	
	
}


