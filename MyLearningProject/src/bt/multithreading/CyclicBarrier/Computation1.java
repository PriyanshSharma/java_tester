package bt.multithreading.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;

public class Computation1 implements Runnable {

	public static int prod = 0;
	@Override
	public void run() {
		prod = 2*3;
		System.out.println("In thread1");
		
		try {
			Thread.sleep(2000);
			CyclicbarrierExample.newBarrier.await();
			System.out.println("Await call in T1");
		} catch (InterruptedException | BrokenBarrierException e) {

			e.printStackTrace();
		}
	}

}
