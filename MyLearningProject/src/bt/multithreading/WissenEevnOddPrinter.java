package bt.multithreading;

public class WissenEevnOddPrinter {

	static int count =0;
	static 	int limit=10;
	
	public static void main(String[] args) {
		
		WissenEevnOddPrinter obj = new WissenEevnOddPrinter();
		
		Thread oddThread = new Thread () {
			@Override
			public void run () {
				obj.printOdd();
			}
		};
		
		Thread evenThread = new Thread () {
			@Override
			public void run () {
				obj.evenPrinter();
			}
		};
		
		evenThread.start();
		oddThread.start();
	}
	
	public void printOdd() {
		
	while(count<=limit) {
		synchronized (this) {
			while(count%2==0 ) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("Odd printer - "+count);
			count++;
			this.notify();
		}
	}
		
	
	}
	public void evenPrinter() {
		
		while(count<=limit) {
			synchronized (this) {
				while(count%2==1 ) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println("Even printer - "+count);
				count++;
				notify();
		}
		
		}
	}
	
	
}
