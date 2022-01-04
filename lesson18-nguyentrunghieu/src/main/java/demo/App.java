package demo;

import java.util.List;

import persistence.Department;
import persistence.DepartmentBudgetDto;
import persistence.DepartmentDetailBuget;
import persistence.Employee;
import persistence.EmployeeDto;
import service.DepartmentServiceImpl;
import service.EmployeeServiceImpl;
import service.departmentService;
import service.employeeService;
import static utils.SqlUtils.*;

public class App {
	private static String dept_id;
	
	private static employeeService employeeService;
	private static departmentService departmentService;
	private static int budget;
	
	static {
		employeeService = new EmployeeServiceImpl();
		departmentService = new DepartmentServiceImpl();
		
		dept_id = "mgm-dn";
		budget = 400;
	}
	public static void main(String[] args) {
		//Ex01
		breakLine("Employee by department_id");
		List<Employee> employees = employeeService.get(dept_id);
		print(employees);
		
		//Ex02
		breakLine("EmployeeDto when order by Dept_id");
		List<EmployeeDto> employeeDtos = employeeService.getEmployeeOrderByDepId();
		print(employeeDtos);
		
		//Ex03
		breakLine("List all project of department which have budget greater than 400");
		List<DepartmentBudgetDto> budgetDtos = departmentService.getDeparmentProjectHaveBugetMoreThan(budget);
		print(budgetDtos);
		
		//Ex04
		breakLine("List total of budget of each department in 2020");
		List<DepartmentDetailBuget> departmentDetailBugets = departmentService.getTotalOfBugetEachDepartment();
		print(departmentDetailBugets);
		
		//Ex05
		breakLine("Department has project highest budget in 2020");
		DepartmentBudgetDto department = departmentService.getDepartmentProjectHaveHighestBuget();
		print("Deparment",department);
		
		//Ex06
//		SELECT * FROM Employee AS employee
//		WHERE employee.salary > (SELECT salary FROM Test AS temp 
//									WHERE temp.id ==  employee.managerId);
		
		

	}
}
