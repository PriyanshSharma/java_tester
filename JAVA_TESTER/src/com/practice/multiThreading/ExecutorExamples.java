package com.practice.multiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.practice.POJO.Employee;

public class ExecutorExamples {

	public static final List<Employee> eList = Employee.getEmployeeList(200000);
	public static final Map<Integer,Employee> empMap  = eList.stream().collect(Collectors.toMap(e->e.getEmpId(), e->e, (e,e1)->e1));
	public static final int NUM_THREADS=20;
	public static void main(String[] args) {
		readListInParellel(eList);
		
	}
	
	
	public static void readListInParellel(List<Employee> myList) {
		// Implement all the tasks here..
		
		long start = System.currentTimeMillis();
		myList.forEach(e->System.out.println("Emp ID - "+e.getEmpId()+" Emp Name - "+e.getName()));
		long end = System.currentTimeMillis();
		
		System.out.println("Total Time taken by single thread - "+(end-start));
		try {
			System.out.println("thread sleeping for some time...");
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		start = System.currentTimeMillis();
		ExecutorService service = Executors.newFixedThreadPool(20);
		
		List<Callable<Void>> runnabletasks = new ArrayList<>();
		
		int chunkSize = myList.size() / NUM_THREADS;
		 for (int i = 0; i < NUM_THREADS; i++) {
	            int startL = i * chunkSize;
	            int endL = (i == NUM_THREADS - 1) ? myList.size() : startL + chunkSize;
	            List<Employee> sublist = myList.subList(startL, endL);
	            int taskId = i + 1;  // Just for identification
	            runnabletasks.add(() -> processList(sublist));  // Callable task
	        }

		try {
			List<Future<Void>> resultSet = service.invokeAll(runnabletasks);
		
		service.shutdown();
		
	        if (!service.awaitTermination(55, TimeUnit.SECONDS)) {  // Waits for existing tasks to finish
	            service.shutdownNow();  // Force shutdown if not finished
	        }
	    } catch (InterruptedException e) {
	        service.shutdownNow();
	        Thread.currentThread().interrupt();
	    }
		System.out.println(" Time taken by multiple threads = "+(System.currentTimeMillis()-start));
	}
	
	private static Void processList(List<Employee> sublist) {
		sublist.stream().map(emp->"Emp id - "+emp.getEmpId()+" Emp Name - "+emp.getName()).collect(Collectors.joining("\n"));
		return null;
	}


	public static void readEmpListById(int empid) {
		
	}
}
