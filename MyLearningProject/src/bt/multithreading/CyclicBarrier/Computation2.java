package bt.multithreading.CyclicBarrier;

import java.util.concurrent.TimeUnit;

public class Computation2 implements Runnable {

	public static int sum = 0 ; 
	
	@Override
	public void run() {
		
		System.out.println("In thread2");
		System.out.println("Is barrier broken -- >>> "+CyclicbarrierExample.newBarrier.isBroken());
		sum = 10+20;
		
		 try
	        {
			 CyclicbarrierExample.newBarrier.await(1000, TimeUnit.MILLISECONDS);
			 System.out.println("Await call in T2");
	            // number of parties waiting at the barrier
	            System.out.println("Number of parties waiting at the barrier "+
	            "at this point = " + CyclicbarrierExample.newBarrier.getNumberWaiting());
	        } catch (Exception e) {

	        }
	}

}
