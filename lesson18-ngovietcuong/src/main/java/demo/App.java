package demo;

import static utils.SqlUtils.breakLine;
import static utils.SqlUtils.print;

import java.util.List;

import persistence.DepartmentDto;
import persistence.Employee;
import persistence.Project;
import service.DepartmentService;
import service.DepartmentServiceImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import service.ProjectService;
import service.ProjectServiceImpl;

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
		breakLine("1. List all employees by department_id");
		List<Employee> employeesByDeptId = employeeService.getEmployee(deptId);
		print(employeesByDeptId);
		
		breakLine("2. List all employees of each department, sorting dept_id ascending");
		List<Employee> employeeSortDeptId = employeeService.getEmployeeSortDeptId();
		print(employeeSortDeptId);
		
		breakLine("3. List all projects of departments which have budget greater than 400 main days");
		List<Project> projectByBudgetGreater = projectService.getProjectByBudgetGreater(budget);
		print(projectByBudgetGreater);
		
		breakLine("4. List total of budget of each department in 2021");
		List<DepartmentDto> deptTotalBudget = departmentService.getDeptTotalBudget(year);
		print(deptTotalBudget);
		
		breakLine("5. Get department which has project with highest budget in 2021");
		DepartmentDto deptHighestBudget = departmentService.getDeptHighestBudget(year);
		print("",deptHighestBudget);
	}
}
