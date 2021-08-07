package collection.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Employee;

public class Ex03 {
	public static void main(String[] args) {
		// Map: manager, List<Employee>
		List<Employee>  flist = Arrays.asList(new Employee(11, "A", 50d, 1), new Employee(12, "B", 50d, 1));
		List<Employee>  slist = Arrays.asList(new Employee(21, "C", 50d, 2), new Employee(22, "D", 50d, 2));
		List<Employee>  tlist = Arrays.asList(new Employee(31, "E", 50d, 3), new Employee(32, "F", 50d, 3));
		
		// put >> exist ? hashcode, equals of KEY
		// hashcode: default  = address
		// 			 override = return calculated value from input (nomal is object's attribute)
		// equals  : default  = compare address
		//			 override = ...
		
		Map<Employee, List<Employee>> teams = new HashMap<>();
		teams.put(new Employee(1, "John", 100d, null), flist);
		teams.put(new Employee(2, "Smith", 150d, null), slist);
		teams.put(new Employee(3, "Andy", 200d, null), tlist);
		
		
		teams.put(new Employee(1, "John", 100d, null), tlist);
		System.out.println("size: " + teams.size());
		
	}
	
}
