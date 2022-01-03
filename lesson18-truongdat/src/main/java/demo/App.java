package demo;
import static utils.SqlUtils.*;

import java.util.List;

import persistences.DepartmentDto;
import persistences.Employee;
import persistences.ProjectDto;
import services.DepartmentSerivceImpl;
import services.DepartmentService;
import services.EmployeeSerivceImpl;
import services.EmployeeService;
import services.ProjectSerivceImpl;
import services.ProjectService;

public class App {
	private static EmployeeService employeeService;
	private static ProjectService projectService;
	private static DepartmentService departmentService;
	
	private static String deptId;
	private static double budget;
	private static int year;
	static {
		employeeService = new EmployeeSerivceImpl(); 
		projectService = new ProjectSerivceImpl();
		departmentService = new DepartmentSerivceImpl();
		
		deptId = "mgm-dn";
		budget = 400;
		year = 2021;
	}
	public static void main(String[] args) {
		breakLine("Q1");
		List<Employee> employees = employeeService.getByDeptId(deptId);
		print(employees);
		
		breakLine("Q2");
		employees = employeeService.getAll();
		print(employees);
		
		breakLine("Q3");
		List<ProjectDto> projectDtos = projectService.getWithBudgetGreaterThan(budget);
		print(projectDtos);
		
		breakLine("Q4");
		List<DepartmentDto> departmentDtos = departmentService.getListTotalBudgetPerDepartmentIn(year);
		print(departmentDtos);
		
		breakLine("Q5");
		DepartmentDto highestBudgest = departmentService.getHighestBudgetIn(year);
		print("highestBudgest", highestBudgest);
	}
}
