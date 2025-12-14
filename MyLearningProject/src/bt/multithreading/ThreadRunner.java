package bt.multithreading;

public class ThreadRunner {

	public static void main(String[] args) {
	
		MyRunnable r = new MyRunnable();
		Thread t = new Thread(r);
		System.out.println("Main thread priority -- > "+Thread.currentThread().getPriority());
		System.out.println("Child Thread priority --- >> "+ t.getPriority());
		
		System.out.println("Setting main thread priority to 7");
		Thread.currentThread().setPriority(7);
		System.out.println("Child Thread priority after setting main thread to 7--- >> "+ t.getPriority());
		
		System.out.println();
		
		//t.start();
		
		for(int i = 0 ; i < 10 ; i++) {
			System.out.println("Main Thread ---- i -- > "+i);
		}
	}
}
