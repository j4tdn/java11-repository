package demo;

import java.util.List;

import persistence.DepartmentBudget;
import persistence.DepartmentBudgetYear;
import persistence.Employee;
import service.DepartmentService;
import service.DepartmentServiceImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import utils.SqlUtils;

public class App {
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	
	static {
		departmentService = new DepartmentServiceImpl();
		employeeService = new EmployeeServiceImpl();
	}
	public static void main(String[] args) {
		SqlUtils.breakLine("example1: List all employees by department_id");
		List<Employee> employeesByID = employeeService.getEmployeeByDept_ID("mgm-dn");
		SqlUtils.print(employeesByID);
		
	
		SqlUtils.breakLine("example2: List all employees of each department, sorting dept_id ascending");
		List<Employee> allEmployees  = employeeService.getAll();
		SqlUtils.print(allEmployees);
		
		
		SqlUtils.breakLine("example3: List all projects of departments which have budget greater than 400 main days");
		List<DepartmentBudget> sumBudgetofDept  = departmentService.getSumBudgetofDept(400);		
		SqlUtils.print(sumBudgetofDept);
		
		SqlUtils.breakLine("example4: List total of budget of each department in 2020");
		List<DepartmentBudgetYear> detailBudgetofDept  = departmentService.getBudgetbyYear(2021);	
		SqlUtils.print(detailBudgetofDept);
		
		SqlUtils.breakLine("example5: Get department which has project with highest budget in 2020");
		List<DepartmentBudget> projectHaveBudgetMax  = departmentService.getProHaveBudMax();
		SqlUtils.print(projectHaveBudgetMax);
		
		//Example 6 :
		
		
		
	}
}
