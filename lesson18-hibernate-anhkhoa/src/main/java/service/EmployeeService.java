package service;

import persistence.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployeeByDept_Id(String dept_id);

}
