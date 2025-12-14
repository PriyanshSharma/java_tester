package com.practice.POJO;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Employee {

	private int empId;
	private String name;
	private double salary;
	private DepartMent departMent;
	
	
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public DepartMent getDepartMent() {
		return departMent;
	}

	public void setDepartMent(DepartMent departMent) {
		this.departMent = departMent;
	}

	public Employee(int i, String name) {
		this.empId = i ;
		this.name = name;
	}
	
	public Employee(int empId, String name, double salary, DepartMent departMent) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.departMent = departMent;
	}

	@Override
	public int hashCode() {
		int number = ThreadLocalRandom.current().nextInt(1, 4);
		System.out.println("Random number = "+number);
		return number;
	}
	@Override
	public boolean equals(Object obj) {
//		return false;
		if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
//	return empId == other.empId && Objects.equals(name, other.name);
	return true;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + ", departMent=" + departMent
				+ "]";
	}

	public static List<Employee> getEmployeeList() {
		List<Employee> emplist = new ArrayList<Employee>();
		
		for(int i =101;i< 110 ;i++) {
			int gen = ThreadLocalRandom.current().nextInt(2, 7);
			Employee e = new Employee(i*gen, "Employee--"+i, i*ThreadLocalRandom.current().nextInt(10, 20), DepartMent.getDefaultDepartMent());
			emplist.add(e);
		}
		
		return emplist;
	}
	public static List<Employee> getEmployeeList(int maxEmployeeGenrator) {
		List<Employee> emplist = new ArrayList<Employee>();
		int maxThread = 5;
		int chunk = maxEmployeeGenrator/5;
		List<Callable<Employee>> alltasks = new ArrayList<Callable<Employee>>();
		List<Integer> iteratorLsit = IntStream.rangeClosed(101, maxEmployeeGenrator).boxed().collect(Collectors.toList());
		for(int i : iteratorLsit) {
			Callable<Employee> cEmp = new Callable<Employee>() {
				
				@Override
				public Employee call() throws Exception {
					int gen = ThreadLocalRandom.current().nextInt(2, 7);
					Employee e = new Employee(i*gen, "Employee--"+i, i*ThreadLocalRandom.current().nextInt(10, 20), DepartMent.getDefaultDepartMent());
					return e;
				}
			};
			alltasks.add(cEmp);
			
		}
		ExecutorService ser = Executors.newFixedThreadPool(2);
		try {
			List<Future<Employee>> empFuture = ser.invokeAll(alltasks);
			for(Future<Employee> f : empFuture){
				emplist.add(f.get());
//				System.out.println(f.get());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return emplist;
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Employee.getEmployeeList(9000000);
		long end = System.currentTimeMillis();
		
		System.out.println(end-start);
	}
}
