package demo;

import service.DeparmentServiceImpl;
import service.DepartmentService;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import service.ProjectService;
import service.ProjectServiceImpl;

import static util.SqlUtils.*;

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
		departmentService = new DeparmentServiceImpl();
	}
	
	public static void main(String[] args) {
		breakLine("C�u 1:");
		List<Employee> employeesById = employeeService.getEmloyeeById("mgm-dn");
		print(employeesById);
		
		breakLine("C�u 2:");
		List<Employee> getAllEmployee = employeeService.getAll();
		print(getAllEmployee);
		
		breakLine("C�u 3:");
		List<Project> getProjectsByBudget =  projectService.getProject(400);
		print(getProjectsByBudget);
		
		breakLine("C�u 4:");
		List<DepartmentDto> totalBudget = departmentService.totalBudgetDepartment(2021);
		print(totalBudget);
		
		breakLine("C�u 5:");
		DepartmentDto getDepartmentHighBudget = departmentService.getDeparmentHighestBudget(2021);
		System.out.println(getDepartmentHighBudget);
	}
	
	
	
}
