package demo;

import static utils.SqlUtils.breakLine;
import static utils.SqlUtils.print;

import java.util.List;

import persistence.DepartmentDto;
import persistence.Employees;
import persistence.Project;
import service.DepartmentService;
import service.DepartmentServiceImpl;
import service.EmpServiceImpl;
import service.EmployeeService;
import service.ProjectService;
import service.ProjectServiceImpl;

public class App {
	
	private static String deptId;
	private static int budget;
	private static int year;

	private static ProjectService projectService;
	private static EmployeeService employeeService;
	private static DepartmentService deptService;

	static {
		deptId = "mgm-dn";
		budget = 400;
		year = 2021;
		employeeService = new EmpServiceImpl();
		projectService = new ProjectServiceImpl();
		deptService = new DepartmentServiceImpl();
	}

	public static void main(String[] args) {
		breakLine("Câu 1:List all employees by department_id");
		List<Employees> employees = employeeService.getEmloyeeById(deptId);
		print(employees);
		
		breakLine("Câu 2:List all employees of each department and sorting dept_id asc");
		List<Employees> Oremployees = employeeService.getAllEmp();
		print(Oremployees);
		
		breakLine("Câu 3:List all project have budget > 400");
		List<Project> projects = projectService.getAllProject(budget);
		print(projects);
		
		breakLine("Câu 4:List total budget of each department in 2020");
		List<DepartmentDto> departList = deptService.getDeptBudget(year);
		print(departList);
		
		breakLine("Câu 5:department which has project with highest budget in 2020");
		DepartmentDto departHighestBudg = deptService.getDeptHighestBudget(year);
		print("Department Highest Budget ",departHighestBudg);
		
		breakLine("Câu 6:SQL query");
//		SELECT  em.Id,
//				em.Name, 
//				em.Salary, 
//				em.ManagerId,
//				ma.Salary 
//	    FROM employee em
//	    JOIN employee mg
//		ON em.ManagerId = ma.Id
//		WHERE em.Salary > ma.Salary
		
}
	}