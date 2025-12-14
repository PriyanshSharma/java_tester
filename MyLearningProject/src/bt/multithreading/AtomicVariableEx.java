package bt.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariableEx {

	
	AtomicInteger counter = new AtomicInteger(1);
	public AtomicVariableEx() {
		
	}

	public void incrementVal() {
		counter.incrementAndGet();
	}

	public static void main(String[] args) {
		AtomicVariableEx ex = new AtomicVariableEx();
		
		int existingVAl = ex.counter.get();
		int updateVale = ex.counter.incrementAndGet();
		ex.counter.compareAndSet(existingVAl, updateVale);
		System.out.println(ex.counter.get());
	}
	
}
