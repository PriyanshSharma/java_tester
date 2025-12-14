package com.practice.multiThreading;

public class ObjectSyncEx {
	
	public static void main(String[] args) {
		Display d = new Display();
		Runnable n = new Runnable() {
			
			@Override
			public void run() {
				d.displayn();
			}
		};
		
		Runnable charR = new Runnable() {
			
			@Override
			public void run() {
				d.displayChar();
			}
		};
		
		Thread nT = new Thread(n);
		Thread cT = new Thread(charR);
		Thread noLock = new Thread(()->d.nolocakReqMethod());
		nT.start();
		cT.start();
		noLock.start();

		
	}
}


class Display {
	
	public synchronized void displayn() {
		for (int i=0;i<10;i++) {
			System.out.println("N thread ="+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("INterrrupted");
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void  displayChar() {
		for (int i =65 ; i<75;i++ ) {
			System.out.println("Char thread -- "+(char)i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Interurpted");
				e.printStackTrace();
			}
		}
	}
	
	public void nolocakReqMethod () {
		for (int i=0;i<10;i++) {
			System.out.println("No lock req printer - "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

}
