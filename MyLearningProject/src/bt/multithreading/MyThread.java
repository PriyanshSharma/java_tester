package bt.multithreading;

public class MyThread extends Thread {

	String name;
	Display d ;
	
	public MyThread(String name, Display d) {
		
		this.name = name;
		this.d =d;
		
	}
	
	@Override
	public void run() {
		d.disp(this.name);
	
	}
}
