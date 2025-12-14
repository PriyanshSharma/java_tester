package bt.multithreading;

import java.util.concurrent.Semaphore;

public class BinarySemaphoresEx {

	Semaphore semaphore = new Semaphore(1);
	public void mutualExclusions()  {
		try {
			semaphore.acquire();
			System.out.println("Lock accquired by -- "+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}finally {
			semaphore.release();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Out side semaphore -- Thread -- "+ Thread.currentThread().getName());
		}
	}
	
	
	public static void main(String[] args) {
		
		BinarySemaphoresEx bin = new BinarySemaphoresEx();
		
		Thread t1 = new Thread () {
			@Override
			public void run () {
				bin.mutualExclusions();
			}
	
		};
		Thread t2 = new Thread () {
			@Override
			public void run () {
				bin.mutualExclusions();
			}
	
		};
		
		t1.start();
		t2.start();
	}
}
