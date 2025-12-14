package bt.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumerOldWay {

	public static void main(String[] args) {
		
		Queue<Integer> resource= new LinkedList<Integer>();
		int max = 10;
		double d=10;
		float f=10;
		
		Runnable producer = ()->{
		while(true) {
			synchronized (resource) {
				while(resource.size()==max) {
					try {
						resource.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				Random random = new Random(); 
				int i = random.nextInt(); 
				System.out.println("Producing value : " + i); 
				resource.add(i); 
				resource.notifyAll();

			
			}
		}
			
		};
		
		Runnable consumer = ()-> {
			
			while(true) {
				synchronized (resource) {
					
					while (resource.isEmpty()) {
						try {
							resource.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("Consuming --- "+resource.remove());
					resource.notifyAll();
				}
			}
			
		};
		
		Thread prod = new Thread(producer);
		Thread consume = new Thread(consumer);
		prod.start();
		consume.start();
	}
}
