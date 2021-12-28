package main;

import java.util.List;
import static utils.HibernateUtils.*;

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
	
	public static EmployeeService employeeService;
	public static ProjectService projectService;
	public static DepartmentService departmentService;
	
	static {
		employeeService = new EmployeeServiceImpl();
		projectService = new ProjectServiceImpl();
		departmentService = new DepartmentServiceImpl();
	}
	
	public static void main(String[] args) {
		breakLine("1. List all employees by department_id");
		List<Employee> listEmployeeById = employeeService.getEmpByDeptId("mgm-dn");
		print(listEmployeeById);
		
		breakLine("2. List all employees of each department, sorting dept_id ascending");
		List<Employee> listEmployee = employeeService.getAll();
		print(listEmployee);
		
		breakLine("3. List all projects of departments which have budget greater than 400 main days");
		List<Project> listProjectByBudgetGreate =  projectService.getProjectByBudgetGreater(400);
		print(listProjectByBudgetGreate);
		
		breakLine("4. List total of budget of each department in 2020");
		List<DepartmentDto> listDepartmentDtos = departmentService.getAllDeptTotalBudget(2021);
		print(listDepartmentDtos);
		
		breakLine("5. Get department which has project with highest budget in 2020");
		DepartmentDto departmentBgHighInYear = departmentService.getDepartmentBudgetHighInYear(2021);
		System.out.println(departmentBgHighInYear);
		
		breakLine("6. Native SQL Interview. Write a query to get the result of requirement below");
		/*
		 * SELECT  e.Id,
				   e.Name, 
			       e.Salary, 
			       e.ManagerId,
			       mg.Salary SalaryManager
			FROM emp e
			JOIN emp mg
				ON e.ManagerId = mg.Id
			WHERE e.Salary > mg.Salary
		 */
	}
}
