epackage com.practice.java8practise.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.practice.POJO.Employee;

public class AllFunctionalInterfaceExamples {
	
	/*1.
	 * Predicate Functional interface test method -- interface Predicate <T> {
	 * boolean test (T t);
	 * 
	 * }
	 * 2.
	 * Function - funtional interface =
	 * interface Funtion <T,R> {
	 * 	public R apply (T t);
	 * }
	 * 3.
	 * Consumer <T> - takes all the things but not produce any thing
	 * for ex - forEach (Cinsumer<T> t).
	 * interface Consumer<T>{
	 * 	public void accept (T t);
	 * 
	 * }
	 * 
	 * 4.
	 * Supplier - Functional interface.
	 * 
	 * ti is used when we want to get the val.
	 * 
	 * interface Supplier <T>{
	 * 	T get();
	 * } 
	 */

	public static void main(String[] args) {
		predicateEx();
		predicateRemoveNullFromList();
		testFuntionFuntionalInterface();
		consumerExample();
		supplierExample();
	}
	
	
	
	public static void predicateEx() {
		Predicate<Integer> intPred = i->i>10;
		
		List<Integer> intList = Arrays.asList(10,20,30,40,4994,454,234,909,111);
		intList.stream().filter(intPred).collect(Collectors.toList()).forEach(System.out::println);
		intList.stream().filter(i->i>10).collect(Collectors.toList()).forEach(System.out::println);

		
	}
	
	public static void predicateRemoveNullFromList() {
		List<String> l = new ArrayList<>(
	               Arrays.asList("Geeks",
	                             null,
	                             "forGeeks",
	                             null,
	                             "A computer portal"));
		Predicate<String> nullStrings = s->s==null;
		// same we can also use or and not
		l.stream().filter(nullStrings.negate()).collect(Collectors.toList()).forEach(System.out::println);
	}
	
	// Function - funtionalInterface..
	
	public static void testFuntionFuntionalInterface() {
		// method apply (t)
		Function<String, Integer> func = s-> s.length();
		Function<Integer,String> multiply = i-> i*2+" ";		
		List<String> listString = Stream.of("Priyansh","Sharma","ABC","Hello DOC","aa","list").collect(Collectors.toList());
		// get all string lenghts
		listString.stream().map(func).forEach(System.out::println);
		System.out.println("Started printing multiply -- ");
		listString.stream().map(func.andThen(multiply)).forEach(System.out::print);
		listString.stream().map(s-> s.length()).map(i-> i*2+" ")
		.forEach(System.out::print);
		
		
		// Convert list of employees to List of String empname.
		
		
		List<Employee> empList = Employee.getEmployeeList();
		System.out.println("Printing employee - - ");
		empList.forEach(System.out::println);
		empList.stream().map(e->e.getName()+" ").forEach(System.out::print);
		
		
	}
	
	public static void consumerExample() {
		
		Consumer<String> con = s->System.out.println(s+" String consumer");
		
		
		con.accept("Employee");
		
		
		// So here peek takes a consumer
		//it can be also use for saving purpose, we can pass any method inside consumer whose return type is void, just like println or save()
		List<Employee> empList = Employee.getEmployeeList();
		
		empList.stream().filter(e->e.getSalary()>1500).peek(e-> System.out.println("Emp with more salary-- "+e.getName()+" - "+e.getSalary())).collect(Collectors.toList());
		
		
		
	}
	public static void supplierExample() {
		
		Supplier<java.util.Date> dateSupp = ()-> new java.util.Date();
		
		System.out.println(dateSupp.get());
		
		List<Employee> empList = Employee.getEmployeeList();
		
		//More to be done during Executor framework, CompletableFuture method supplyAsync takes SUpplier as an arg.
	}
	
}
