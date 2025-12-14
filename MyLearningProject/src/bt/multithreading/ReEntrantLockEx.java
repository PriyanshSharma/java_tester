package bt.multithreading;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLockEx {

	public static void main(String[] args) {
		
		ExecutorService pool = Executors.newFixedThreadPool(2);
		ReentrantLock rel = new ReentrantLock();
	    Runnable w1 = new Worker(rel, "Job1");
	    Runnable w2 = new Worker(rel, "Job2");
	    Runnable w3 = new Worker(rel, "Job3");
	    Runnable w4 = new Worker(rel, "Job4");
	    pool.execute(w1);
	    pool.execute(w2);
	    pool.execute(w3);
	    pool.execute(w4);
	    pool.isShutdown();
}
	
}

class Worker implements Runnable{
	
	
	ReentrantLock lock;
	String name;
	@Override
	public void run() {
		boolean done =false;
		while(!done) {
			try {
				if(lock.tryLock()) {
					Date d = new Date();
					System.out.println("Outer task performed by --"+name +" at time -- "+d.toString() );
					Thread.sleep(1500);
					try {
					if(lock.tryLock()) {
						
						d= new Date();
						System.out.println("Inner task performaed by task name -- "+name +" a time "+d.toString());
					}
					}finally {
						System.out.println("releasing inner thread of job name -- "+name);
						lock.unlock();
					}
				}
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}finally {
				System.out.println("Releasing outer lock by job -- "+name);
				lock.unlock();
			}
		done=true;
		}
				
	}
	
	public Worker(ReentrantLock lock, String name) {
		this.lock = lock;
		this.name=name;
	}
}