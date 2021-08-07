package collection.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Employee;

public class Ex03 {
	public static void main(String[] args) {
		List<Employee> flist = Arrays.asList(new Employee(11, "A", 50, 1), new Employee(12, "B", 50, 1));

		List<Employee> slist = Arrays.asList(new Employee(21, "C", 50, 1), new Employee(22, "D", 50, 1));

		List<Employee> tlist = Arrays.asList(new Employee(31, "E", 50, 1), new Employee(32, "F", 50, 1));

		Map<Employee, List<Employee>> teams = new HashMap<Employee, List<Employee>>();

		teams.put(new Employee(1, "John", 100, null), flist);
		
		teams.put(new Employee(2, "Smith", 150, null), slist);

		teams.put(new Employee(3, "Andy", 200, null), tlist);
		
		teams.put(new Employee(1, "John", 100, null), tlist);

		
		System.out.println("size: " +teams.size());

	}
}
