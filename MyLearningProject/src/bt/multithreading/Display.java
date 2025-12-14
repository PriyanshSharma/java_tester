package bt.multithreading;


public class Display {

	
	public synchronized void disp(String name) {
		
		for(int i = 0 ; i < 10 ; i++) {
			
			System.out.println("Good mornign..... ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name);
		}
	}
}
