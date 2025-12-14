package bt.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerBlockingQueue {
	
	public static void main(String[] args) {
		BlockingQueue<Integer> sharedResource = new LinkedBlockingQueue();
		Runnable producer = ()-> {
			for(int i = 0 ; i < 10 ; i ++) {
				System.out.println("Producing -- "+i);
				
				try {
					sharedResource.put(i);
					System.out.println("Sleeping ..");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Runnable consumer = ()-> {
			while (true) {
				try {
					System.out.println("Consuming "+sharedResource.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Thread prod = new Thread(producer);
		Thread consume = new Thread(consumer);
		prod.start();
		consume.start();
	}
	
	
	
	
	
	
	
}

