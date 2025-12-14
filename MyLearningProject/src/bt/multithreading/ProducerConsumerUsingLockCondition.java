package bt.multithreading;

import java.util.Random;
import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerUsingLockCondition {
	
	static Lock lock = new ReentrantLock();
	static Condition produdeCondition = lock.newCondition();
	static Condition consumerCondition = lock.newCondition();
	static Stack<Integer> stackResource = new Stack<Integer>();
	static Random random = new Random();
	public static void main(String[] args) {
	
		Thread producer= new Thread () {
			
			@Override
			public void run () {
				
				lock.lock();
				try {
					while(stackResource.size()==10) {
						produdeCondition.await();
					}
					int producedVal = random.nextInt();
						System.out.println("Producing in stack --- "+random.nextInt());
						stackResource.push(producedVal);
						Thread.sleep(1000);
						System.out.println("Producing in stack --- "+random.nextInt());
						stackResource.push(producedVal);
						Thread.sleep(1000);
						System.out.println("Producing in stack --- "+random.nextInt());
						stackResource.push(producedVal);
						Thread.sleep(1000);
						System.out.println("Producing in stack --- "+random.nextInt());
						stackResource.push(producedVal);
						Thread.sleep(1000);
						System.out.println("Producing in stack --- "+random.nextInt());
						stackResource.push(producedVal);
						Thread.sleep(1000);
						System.out.println("Producing in stack --- "+random.nextInt());
						stackResource.push(producedVal);
						Thread.sleep(1000);
						System.out.println("Producing in stack --- "+random.nextInt());
						stackResource.push(producedVal);
						Thread.sleep(1000);
					
					consumerCondition.signalAll();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
				}
				
		};
		
		
		Thread consumer = new Thread () {
			
			@Override
			public void run () {
				
				lock.lock();
				try {
					while(stackResource.isEmpty()) {
						consumerCondition.await();
					}
					
						System.out.println("Consuming the stack --- "+stackResource.pop());
						Thread.sleep(2000);
					
					produdeCondition.signalAll();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
				}
				
		};
		
		
		producer.start();
		consumer.start();
	}
	
	
}
