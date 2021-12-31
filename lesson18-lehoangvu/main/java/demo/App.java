package demo;

import persistence.DepartmentDto;
import persistence.DepartmentMaxBudgetDto;
import persistence.Employees;
import persistence.Project;
import service.*;

import java.util.List;

import static utils.SqlUtils.*;

public class App {

    private static EmployeesService employeesService;

    private static ProjectService projectService;

    private static DepartmentService departmentService;


    static {
        employeesService = new EmployeesServiceImpl();
        projectService   = new ProjectServiceImpl();
        departmentService= new DepartmentServiceImpl();


    }
    public static void main(String[] args) {

        breakLine("1: List all employees by department_id");

        List<Employees> employees = employeesService.getAll("mgm-dn");
        print("employees: ",employees);

        breakLine("2: List all employees of each department,s sorting dept_id ascending");


        List<Employees> Two = employeesService.getEmployee();
        print(Two);

        breakLine("3. List all projects of departments which have budget greater than 400 main days ");
        List<Project> Three = projectService.getProject(400);
        print("Three: ",Three);

        breakLine("4. List total of budget of each department in 2020 ");

        List<DepartmentDto> four = departmentService.getTotal(2021);
        print(four);

        breakLine("5.Get department which has project with highest budget in 2020");
        List<DepartmentMaxBudgetDto> five = departmentService.getMaxBudget(2021);
        print("five:" ,five);


    }
}
