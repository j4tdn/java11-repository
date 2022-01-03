package demo;

import static utils.SqlUtils.*;

import java.util.List;

import persistence.Employee;
import persistence.Project;
import persistence.DepartmentDto;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import service.DepartmentService;
import service.DepartmentServiceImpl;
import service.ProjectService;
import service.ProjectServiceImpl;

public class App {
	private static EmployeeService employeeService = new EmployeeServiceImpl();
	private static ProjectService projectService = new ProjectServiceImpl();
	private static DepartmentService departmentService = new DepartmentServiceImpl();
	
	public static void main(String[] args) {
		
		breakLine("cau 1");
		List<Employee> employees = employeeService.getAll();
		print(employees);
		
		breakLine("cau 2");
		List<Employee> empSortByDeptIds = employeeService.getAllAndSortByDeptId();
		print(empSortByDeptIds);
		
		breakLine("cau 3");
		List<Project> proByBudgets = projectService.getByBudget(400d);
		print(proByBudgets);
		
		breakLine("cau4");
		List<DepartmentDto> cau4s = departmentService.getTotalOfDepartmentInYear(2021);
		print(cau4s);
		
		breakLine("cau5");
		DepartmentDto cau5 = departmentService.getDepartmentHighestBudgetInYear(2021);
		print("department has project with highest in 2021", cau5);
	}
}
