package demo;

import static utils.SqlUtils.*;

import java.util.List;

import persistence.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class App {

	private static String deptId;
	private static double budget;
	private static int year;
	
	private static EmployeeService employeeService;
	private static ProjectService projectService;
	private static DepartmentService departmentService;
	
	static {
		deptId = "mgm-dn";
		budget = 400;
		year = 2021;
		
		employeeService = new EmployeeServiceImpl();
		projectService = new ProjectServiceImpl();
		departmentService = new DepartmentServiceImpl();
	}
	
	public static void main(String[] args) {
		breakLine("Cau 1");
		List<Employee> employeesByDeptId = employeeService.getEmployee(deptId);
		print(employeesByDeptId);
		
		breakLine("Cau 2");
		List<Employee> employeeSortDeptId = employeeService.getEmployeeSortDeptId();
		print(employeeSortDeptId);
		
		breakLine("Cau 3");
		List<Project> projectByBudgetGreater = projectService.getProjectByBudgetGreater(budget);
		print(projectByBudgetGreater);
		
		breakLine("Cau 4");
		List<DepartmentDto> deptTotalBudget = departmentService.getDeptTotalBudget(year);
		print(deptTotalBudget);
		
		breakLine("Cau 5");
		DepartmentDto deptHighestBudget = departmentService.getDeptHighestBudget(year);
		print("",deptHighestBudget);
	}
}
