package com.practice.java8practise.lamda;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.practice.POJO.Employee;
import com.practice.POJO.SorterConstants;

public class SortingExampleJava8 {
	
	
	public static void main(String[] args) {
		sortEmployee(Employee.getEmployeeList(), SorterConstants.DEPTID);
		sortUsingComparatorcomparing(Employee.getEmployeeList(), SorterConstants.SALARY);
		String minormax="min";
		sortAndGetMinMax(Employee.getEmployeeList(),minormax);
	}
	
	
	private static void sortAndGetMinMax(List<Employee> employeeList, String minormax) {
		employeeList.stream().forEach(System.out::println);
		Employee e = employeeList.stream().min(Comparator.comparing(Employee::getSalary)).get();
				System.out.println("min Salary -- "+e);
//				.collect(Collectors.toList());
	}


	public static void sortEmployee(List<Employee> emp , SorterConstants empComparator) {
		
		System.out.println("Before Sorting -- ");
		emp.forEach(System.out::println);

		switch (empComparator) {
		case SALARY: {
			
			emp = emp.stream().sorted((i1,i2)-> (i1.getSalary()<i2.getSalary())?-1:(i1.getSalary()>i2.getSalary())?1:0)
					.collect(Collectors.toList());
			break;
		}
		case ID: {
			
			emp = emp.stream().sorted((i1,i2)-> (i1.getEmpId()<i2.getEmpId())?-1:(i1.getEmpId()>i2.getEmpId())?1:0)
					.collect(Collectors.toList());
			break;
		}
		case NAME: {
			
			emp = emp.stream().sorted((i1,i2)-> (i1.getName().compareTo(i2.getName())))
					.collect(Collectors.toList());
			break;
		}
		
		case DEPTID: {
			
			emp = emp.stream().sorted((i1,i2)-> (i1.getDepartMent().getDeptId()<i2.getDepartMent().getDeptId())?-1:
													(i1.getDepartMent().getDeptId()>i2.getDepartMent().getDeptId())?1:0)
					.collect(Collectors.toList());
			break;
		}
		
		case DEPTNAME: {
			
			emp = emp.stream().sorted((i1,i2)-> (i1.getDepartMent().getDeptName().compareTo(i2.getDepartMent().getDeptName())))
					.collect(Collectors.toList());
			break;
		}

		default:
			System.out.println("Unknown comparator");
		}
		
		System.out.println("Sortint Based on -- "+empComparator.name());
		emp.forEach(System.out::println);

	}
	
	public static void sortUsingComparatorcomparing(List<Employee> emp , SorterConstants empComparator) {
		System.out.println("Before Sorting -- ");
		emp.forEach(System.out::println);

		switch (empComparator) {
		case SALARY: {
			Function<Employee, Double> salFunction = e->e.getSalary();
			Comparator<Employee> empSalComp = Comparator.comparing(salFunction);
			emp = emp.stream().sorted(Comparator.comparing(e->e.getSalary())).collect(Collectors.toList());
			break;
		}
		case ID: {
			
			emp = emp.stream().sorted(Comparator.comparing(e->e.getEmpId()))
					.collect(Collectors.toList());
			break;
		}
		case NAME: {
			
			emp = emp.stream().sorted(Comparator.comparing(e->e.getName()))
					.collect(Collectors.toList());
			break;
		}
		
		

		default:
			System.out.println("Unknown comparator");
		}
		
		System.out.println("Sortint using comparator.comparing -- Based on -- "+empComparator.name());
		emp.forEach(System.out::println);
		
	}
}
