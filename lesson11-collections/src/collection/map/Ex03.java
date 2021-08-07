package collection.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import bean.Employee;

public class Ex03 {
	public static void main(String[] args) {
		// Map: Employee, List<Employee>
		List<Employee> flist = Arrays.asList(new Employee(11, "A", 50, 1), new Employee(12, "B", 50, 1));
		List<Employee> slist = Arrays.asList(new Employee(21, "C", 30, 2), new Employee(22, "D", 50, 2));
		List<Employee> tlist = Arrays.asList(new Employee(31, "E", 10, 3), new Employee(32, "F", 50, 3));

		// put >> exist ? hashcode, equals of KEY
		// hashcode: default = address
		// hashcode: override = calculated value from input (normal is object's
		// attributes)
		// equals: default = compare address
		// equals: override = ...

		Map<Employee, List<Employee>> teams = new HashMap<>();
		teams.put(new Employee(1, "John", 100, null), flist);
		teams.put(new Employee(2, "Smith", 150, null), slist);
		teams.put(new Employee(3, "Andy", 250, null), tlist);
		teams.put(new Employee(1, "John", 100, null), tlist);

		System.out.println("size: " + teams.size());
		iterator(teams);
	}

	public static void iterator(Map<Employee, List<Employee>> mapEmp) {
		for (Entry<Employee, List<Employee>> entry : mapEmp.entrySet()) {
			System.out.println("key : " + entry.getKey());
			System.out.println("values : " + entry.getValue());
		}
	}
}
