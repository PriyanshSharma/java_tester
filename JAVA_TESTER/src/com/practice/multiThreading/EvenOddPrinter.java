package com.practice.multiThreading;

public class EvenOddPrinter {
	
	final static int max=10;
	static int count =1;
public static void main(String[] args) {
	
	EvenOddPrinter obj = new EvenOddPrinter();
	
	Runnable even = new Runnable() {
		
		@Override
		public void run() {
			obj.evenPrinter();
		}
	};
	
Runnable odd = new Runnable() {
		
		@Override
		public void run() {
			obj.oddPrinter();
		}
	};
	
	new Thread(even).start();
	new Thread(odd).start();
}

	
	public void evenPrinter() {
		while (count<max) {
			synchronized (this) {
				if(count%2==1) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Even Number -- "+count++);
				this.notifyAll();
			}
			
		}
	}
	
	public void oddPrinter() {
		while (count<max) {
			synchronized (this) {
				if(count%2==0) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Odd Number -- "+count++);
				this.notifyAll();
			}
			
		}
	}
}
