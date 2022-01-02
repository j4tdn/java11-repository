package demo;

import persistent.DepartmentDto;
import persistent.Employee;
import persistent.EmployeeDto;
import persistent.ProjectDto;
import service.*;

import java.util.List;

import static utils.SqlUtils.breakLine;
import static utils.SqlUtils.print;

public class App {

    private static final String department_id;

    private static EmployeeService employeeService = new EmployeeServiceImpl();
    private static ProjectService projectService = new ProjectServiceImpl();
    private static DepartmentService departmentService = new DepartmentServiceImpl();

    static {
        department_id = "mgm-dn";
    }

    public static void main(String[] args) {
        breakLine("Cau 1");
        List<Employee> employees = employeeService.get(department_id);
        print(employees);

        breakLine("Cau 2");
        List<EmployeeDto> employeeDtos = employeeService.getAllOrderByDeptId();
        print(employeeDtos);

        breakLine("Cau 3");
        List<ProjectDto> projectDtos = projectService.getAllBudgetGreaterThan400();
        print(projectDtos);

        breakLine("Cau 4");
        List<DepartmentDto> departmentDtos = departmentService.getAllDepartmentTotalBudget();
        print(departmentDtos);

        breakLine("Cau 5");
        DepartmentDto departmentDto = departmentService.getHighestBudgetDepartment();
        System.out.println(departmentDto);
    }
}
