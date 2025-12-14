package com.practice;

public class TCSOddEvenprinter {

	static final int maxCount = 10;
	static int currntCount = 1;

	public static void main(String[] args) {

		
		TCSOddEvenprinter o = new TCSOddEvenprinter();
				
		Runnable oddPrint = new Runnable() {

			@Override
			public void run() {
					o.oddPrinter();
				
			}
		};

		Runnable evenprrinter = new Runnable() {

			@Override
			public void run() {
				o.evenPrinter();
			}
		};

		Thread oddThread = new Thread(oddPrint, "Odd thread = ");
		Thread evenThread = new Thread(evenprrinter, "Even thread = ");

		oddThread.start();
		evenThread.start();

	}
	
	public void evenPrinter() {
		while (currntCount<maxCount) {
			synchronized (this) {
				if(currntCount%2==1) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Even Number -- "+currntCount++);
				this.notifyAll();
			}
			
		}
	}
	
	public void oddPrinter() {
		while (currntCount<maxCount) {
			synchronized (this) {
				if(currntCount%2==0) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Odd Number -- "+currntCount++);
				this.notifyAll();
			}
			
		}
	}

}
