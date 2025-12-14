package com.practice;

public class JugleeGames {

	private  static final int max=10;
	private static int counter =1;
	public static void main(String[] args) {
		//Print 1-10. 
		// One thread - even
		//One thread - odd
		//seq follow
		JugleeGames obj = new JugleeGames();
		Runnable evenrun = ()->obj.evenPrint();
		Runnable oddRun = ()->obj.oddPrinter();
		
		Thread evenThread = new Thread(evenrun);
		Thread oddThread = new Thread(oddRun);
		
		evenThread.start();
		oddThread.start();
		
		
		

	}
	
	public void evenPrint() {
		
		while (counter<max) {
			synchronized (this) {
				if(counter%2!=0) {
					try {
						this.wait();
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println("Printed By even thread = "+counter);
				
				this.notifyAll();
			}
		}
	}
	
	public void oddPrinter() {
		while (counter<max) {
			synchronized (this) {
				if(counter%2==0) {
					try {
						this.wait();
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println("Printed By Odd thread = "+counter);
				
				this.notifyAll();
			}
		}
	}
}
