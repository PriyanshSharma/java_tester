package com.practice.multiThreading;

public class SyncBlockexample {

	public static void main(String[] args) {
		DisplaySycnBlockEx d = new DisplaySycnBlockEx();
		
		new Thread(()->d.displayn()).start();
		new Thread(()->d.displayChar()).start();

	}
}
class DisplaySycnBlockEx {
	
	public  void displayn() {
		for (int i=0;i<10;i++) {
			System.out.println("outisde sync -- i = "+i);
			synchronized (this) {
				System.out.println("Started sync block for N-- ");
				System.out.println("N thread ="+i);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println("INterrrupted");
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public  void  displayChar() {
		for (int i =65 ; i<75;i++ ) {
			System.out.println("Outside synch block Char - "+(char)i);
			
			synchronized (this) {
				System.out.println("Inside sync block -- "+(char)i);
				System.out.println("Char thread -- "+(char)i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("Interurpted");
					e.printStackTrace();
				}
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