package bt.multithreading;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockEx {
	
	public static void main(String[] args) {
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		
		MyThread[] t = new MyThread[5];
		
		for(int i = 0 ; i < 5 ; i ++) {
			if(i%2==0) {
				t[i] = new ReadWriteLockEx().new MyThread(lock, "i"+i, "r");
			}
			else {
				t[i] = new ReadWriteLockEx().new MyThread(lock, "i"+i, "w");
			}
		}
		for(MyThread myt : t) {
			myt.start();
		}
	}
	
	
	public class MyThread extends Thread{
		
		ReentrantReadWriteLock lock = null;
		String readWrite = null;
		
		public MyThread() {
			
		}
		public MyThread(ReentrantReadWriteLock lock,String name,String rw) {
			
			super(name);
			
			this.lock = lock;
			this.readWrite=rw;
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void run() {
			if(readWrite =="w") {
				lock.writeLock().lock();
			}
			if(readWrite=="r") {
				lock.readLock().lock();
			}
			System.out.println(Thread.currentThread().getName()+" got the lock "+lock);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(readWrite =="w") {
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lock.writeLock().unlock();
			}
			if(readWrite=="r") {
				lock.readLock().unlock();
			}
			
			System.out.println(Thread.currentThread().getName()+" releases the lock "+lock);
		}
	}
}
