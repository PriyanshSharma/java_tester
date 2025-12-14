package com.practice;

public class CiscoExThread {
	
	
public static void main(String[] args) {
	
	Printer p = new Printer();
	
	
	
	Runnable even = new Runnable() {
		
		@Override
		public void run() {
			p.printEven();
			
		}
	};
	
	Runnable odd = new Runnable() {
		
		@Override
		public void run() {
			p.printOdd();
			
		}
	};
	Thread oddThread = new Thread(odd);
	Thread evenThread = new Thread(even);
	
	Runnable summer = new Runnable() {
		
		@Override
		public void run() {
		
			p.printSummer();
			
		}
	};
	

	Thread summerThread = new Thread(summer);
	
	oddThread.start();
	evenThread.start();
	summerThread.start();
	
	
}



}

class Printer {
	
	static int maxLimit=10;
	static int count =1;
	int oddNumber = 0;
	int evenNumber =0;
	int sum = 0;
	
	public void printEven () {
		
		synchronized (this) {
			while (count<=maxLimit) {
				while (count%2==1) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println(count);
				evenNumber = count;
				
				count++;
				notifyAll();
			}
			
		}
		
	}
	
	
	
	public void printOdd () {
		
		synchronized (this) {
			
			while (count<=maxLimit) {
				while (count%2==0) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println(count);
				oddNumber = count;
				count++;
				notifyAll();
			}
			
		}
		
	}
	
	public void printSummer () {
		
		synchronized (this) {
			while (sum==0) {
				try {
					sum=evenNumber+oddNumber;
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("Summ is "+sum);
			
			notifyAll();
			
		}
		
	}
	
}
	
