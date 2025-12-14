package com.practice;





/*
 * even odd printer by diff threads
 */
public class NetCrackerEx {
	int count = 1;
	static int tillCount =10;
	public static void main(String[] args) {
		
		NetCrackerEx nt = new NetCrackerEx();
		Thread t1 = new Thread(()->{
			try {
				nt.evenPrinter();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} );
		
		Thread t2 = new Thread(()->{
			try {
				nt.oddPrinter();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} );
		
		t1.start();
		t2.start();
	}

	public void evenPrinter() throws InterruptedException {

		synchronized (this)
        {
            // Print number till the N
            while (count < tillCount) {
  
                // If count is odd then print
                while (count % 2 == 1) {
  
                    // Exception handle
                    try {
                        wait();
                    }
                    catch (
                        InterruptedException e) {
                        e.printStackTrace();
                    }
                }
  
                // Print the number
                System.out.println("Even printer "+count + " ");
  
                // Increment counter
                count++;
  
                // Notify to 2nd thread
                notify();
            }
			
		}

	}

	public void oddPrinter() throws InterruptedException {
			
		 synchronized (this)
	        {
	            // Print number till the N
	            while (count < tillCount) {
	  
	                // If count is even then print
	                while (count % 2 == 0) {
	  
	                    // Exception handle
	                    try {
	                        wait();
	                    }
	                    catch (
	                        InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                }
	  
	                // Print the number
	                System.out.println("Odd printer -- "+count);
	  
	                // Increment counter
	                count++;
	  
	                // Notify to second thread
	                notify();
	            }
	        }
	}
}
