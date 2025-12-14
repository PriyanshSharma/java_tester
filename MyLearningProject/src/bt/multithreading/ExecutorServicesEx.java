package bt.multithreading;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServicesEx {

	public static List<String> myCutom = Arrays.asList("acb","aljsflkdsaf","afdsaf","asjaks","jaslkfsa"
			,"kaysifajdslkfdsa");
	static int coutn=0;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		/*
		 * Callable<String> callTask = ()->{
		 * 
		 * System.out.println("Inside Callabe,,,, "); Thread.sleep(5000); return
		 * "Hello"; };
		 * 
		 * ExecutorService service = Executors.newFixedThreadPool(2); Future<String>
		 * future =service.submit(callTask); System.out.println(future.isDone());
		 * 
		 * System.out.println("Shutting main......"); service.shutdown();
		 * System.out.println(future.get());
		 * 
		 * System.out.println("Service shutdwn status ---- "+service.isShutdown());
		 */
		
		readListInParellel();
	}
	
	
	
	
	
	public static void readListInParellel() throws InterruptedException {
	List<Callable<Integer>> callableLsit = new ArrayList<Callable<Integer>>();
		myCutom.forEach(s-> {
			Callable<Integer> c = ()-> {
				int coutn=0;
				coutn += s.length();
				return coutn;
			};
			System.out.println("Calable value == "+coutn);
			callableLsit.add(c);
			
		});
		
		ExecutorService summerService = Executors.newFixedThreadPool(2);
		List<Future<Integer>> futureLsit = summerService.invokeAll(callableLsit);
		
		futureLsit.forEach(f-> {
			if(f.isDone()) {
				try {
					coutn += f.get();
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		summerService.shutdown();
		
		System.out.println(coutn);
		
	}
}
