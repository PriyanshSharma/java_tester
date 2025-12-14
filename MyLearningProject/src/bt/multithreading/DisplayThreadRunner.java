package bt.multithreading;

public class DisplayThreadRunner {

	
	public static void main(String[] args) {
		Display d = new Display();
		
		Runnable r = ()-> {
			d.disp("Dhoni");
		};
		
		Runnable r1 = ()-> {
			d.disp("Yuvraaj");
		};
	
		Thread t = new Thread(r);
		Thread t1 = new Thread(r1);
		t1.start();
		t.start();
		
	}
}
