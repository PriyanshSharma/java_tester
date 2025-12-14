package bt.dataLayer;

import java.util.Arrays;
import java.util.List;

import bt.models.Address;
import bt.models.Employee;

public class EmployeeProvider {

	public static final List<Employee> getEmployee (){
		
		Employee e = new Employee("101", "Priyansh", 50000d, "Sharma", new Address("Bilaspur", "st-A", "35/34"));
		Employee e1 = new Employee("101", "Priyansh", 60000d, "Adhikari", new Address("Raipur", "st-b", "35/34"));
		Employee e2 = new Employee("101", "Ruchi", 65000d, "Sharma", new Address("Ambikapur", "st-c", "35/34"));
		Employee e3 = new Employee("101", "Ruchi", 39000d, "Trivedi", new Address("chembur", "st-h", "35/34"));
		Employee e4 = new Employee("101", "Srishti", 98989d, "Sharma", new Address("Delhi", "st-kj", "35/34"));
		Employee e5 = new Employee("101", "Srishti", 89998.90, "Adhikari", new Address("Abra", "st-j", "35/34"));
		
		return Arrays.asList(e,e1,e2,e3,e4,e5);
	}
	
	
	
}
