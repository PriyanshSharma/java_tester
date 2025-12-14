package bt.multithreading;

public class MyCustomBlockingQueue {
	static int[] arr ;
	int front=0;
	int rear =-1;
	int count=0;
	
	
	public MyCustomBlockingQueue(int capacity) {
			arr = new int [capacity];
	}
	
	public void adddata(int data) throws InterruptedException {
		
		synchronized (arr) {
			while(arr.length==count) {
				arr.wait();
			}
			rear++;
			
			System.out.println("Producing --- "+data);
			arr[rear]=data;
			count++;
			arr.notifyAll();
		}
	}
	
	public int removeData() throws InterruptedException {
		
		
		int value = arr[front];
		synchronized (arr) {
			
			while(count==0) {
				arr.wait();
			}
			
			for(int i = 0 ; i < count-1 ; i++) {
				arr[i]=arr[i+1];
				
			}
			
			rear--;
			count--;
			System.out.println("Consuming -- "+value);
			arr.notify();
			
		}
		return value;
	}
	
	
	
	public static void main(String[] args) {
		final MyCustomBlockingQueue queue = new MyCustomBlockingQueue(10);
	Runnable produce = ()-> {
		
		for(int i = 0 ; i < 10 ; i++) {
			try {
				queue.adddata(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	};
	
	Runnable cnsumer = ()-> {
		int val=0;
		try {
			while(true) {
				val = queue.removeData();
				System.out.println(val);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	};
	
	Thread t1 = new Thread(produce);
	Thread t2 = new Thread(cnsumer);
	
	t1.start();
	t2.start();
	}
}
