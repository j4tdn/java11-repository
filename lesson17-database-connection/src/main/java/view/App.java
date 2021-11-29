package view;

import service.EmployeeService;
import service.EmployeeServiceImpl;
import service.ItemGroupServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
	private static ItemGroupServiceImpl itemGroupService;
	private static EmployeeService employeeService;
	static {
		itemGroupService = new ItemGroupServiceImpl();
		employeeService = new EmployeeServiceImpl();
	}

	public static void main(String[] args) {
		System.out.println(employeeService.signin("ny", "khoa123"));
	}
}
