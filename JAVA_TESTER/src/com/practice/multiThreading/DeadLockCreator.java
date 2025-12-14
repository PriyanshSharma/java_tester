package com.practice.multiThreading;

public class DeadLockCreator {

	public static void main(String[] args) {
		SharedResource s1 = new SharedResource();
		SharedResource s2 = new SharedResource();
		
		Thread t1  = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				s1.printer(s2);
			}
		});
		
		Thread t2  = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				s2.printer(s1);
			}
		});
		
		t1.start();
		t2.start();
	}
}


class SharedResource {
	
	public synchronized void printer(SharedResource res) {
		
		System.out.println("This is printer accquired lock resource by .."+Thread.currentThread().getName());
		
		System.out.println("Now calling last method from -- "+Thread.currentThread().getName());
		
		res.last();
		
	}
	
	public  synchronized void last() {
		
		System.out.println("This is last method locked by .."+Thread.currentThread().getName());
	}
	
}
