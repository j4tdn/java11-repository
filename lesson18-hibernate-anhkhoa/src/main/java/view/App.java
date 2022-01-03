package view;

import service.DepartmentService;
import service.DepartmentServiceImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class App {

    private static final EmployeeService employeeService;
    private static final DepartmentService departmentService;

    static {
        employeeService= new EmployeeServiceImpl();
        departmentService = new DepartmentServiceImpl();
    }
    public static void main(String[] args) {
        //Q1 SqlUtils.print(employeeService.getEmployeeByDept_Id("mgm-dn"));
        //Q2 SqlUtils.print(departmentService.getEmployeesEachDepartment());
        //Q3 SqlUtils.print(departmentService.getSumBudget());
        //Q4 SqlUtils.print(departmentService.getListTotal());
        //Q5 SqlUtils.print(departmentService.getMaxBudget());
        //Q6 select * from test as t where t.salary>(select salary from test where test.id=t.managerid)
    }
}
