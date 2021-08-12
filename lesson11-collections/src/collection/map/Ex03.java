package collection.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Employee;

public class Ex03 {
	public static void main(String[] args) {
		//Map: Employee, List<Employee>
		List<Employee> firstList = Arrays.asList(new Employee(11, "A", 50, 1), new Employee(12, "B", 40, 1));
		List<Employee> secondList = Arrays.asList(new Employee(21, "Anna", 10, 2), new Employee(12, "Ben", 10, 2));
		List<Employee> thirdList = Arrays.asList(new Employee(31, "Alex", 10, 3), new Employee(32, "Luke", 10, 3));
		
		//put >> exist ? hashcode, equals OF KEY
		//hashcode: default = address 
		//			override  = calculated value from input (normal is object's attributes)
		//equals   :  default = compare address
		//			override = .....
		
		Map<Employee, List<Employee>> teams = new HashMap<>();
		teams.put(new Employee(1, "John", 100, null), firstList);
		teams.put(new Employee(2, "Smith", 150, null), secondList);
		teams.put(new Employee(3, "Zizky", 200, null), thirdList);
		teams.put(new Employee(1, "John", 100, null), thirdList);
		
		System.out.println("size: " + teams.size());
	}
}
