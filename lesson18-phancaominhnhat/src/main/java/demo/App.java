package demo;

import service.DepartmentService;
import service.DepartmentServiceImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import service.ProjectService;
import service.ProjectServiceImpl;

import static utils.HibernateUtils.*;

import java.util.List;

import persistence.DepartmentDto;
import persistence.Employee;
import persistence.Project;

public class App {
	private static EmployeeService employeeService;
	private static ProjectService projectService;
	private static DepartmentService departmentService;
	
	static {
		employeeService = new EmployeeServiceImpl();
		projectService = new ProjectServiceImpl();
		departmentService = new DepartmentServiceImpl();
	}
	
	public static void main(String[] args) {
		breakLine("1. List all employees by department_id");
		List<Employee> groupEmployees = employeeService.getEmployeeByDeptId("mgm-dn");
		print(groupEmployees);
		
		breakLine("2. List all employees of each department, sorting dept_id ascending ");
		List<Employee> groupEmployeesWithDept = employeeService.getAll();
		print(groupEmployeesWithDept);
		
		breakLine("3. List all projects of departments which have budget greater than 400 main days");
		List<Project> groupProjectByBudgetGreater =  projectService.getProjectByBudgetGreater(400);
		print(groupProjectByBudgetGreater);
		
		breakLine("4. List total of budget of each department in 2020");
		List<DepartmentDto> listDepartmentDtos = departmentService.getTotalBudgetOfDept(2021);
		print(listDepartmentDtos);
		
		breakLine("5. Get department which has project with highest budget in 2020");
		DepartmentDto departmentBgHighInYear = departmentService.getDepartmentBudgetHighInYear(2021);
		System.out.println(departmentBgHighInYear);
		
		breakLine("6. Native SQL Interview. Write a query to get the result of requirement below");
		String query = "SELECT id, name, salary, managerId \n"
					+ "FROM employee\n"
					+ "LEFT JOIN manager\n"
					+ "	ON employee.managerId = manager.managerId\n"
					+ "WHERE employee.salary > manager.salary;";
		System.out.println(query);
	}
}
