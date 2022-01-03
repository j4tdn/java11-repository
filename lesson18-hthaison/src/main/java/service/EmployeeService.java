package service;

import java.util.List;

import persistence.Employee;

public interface EmployeeService {
	List<Employee> getEmployeeByDept_ID(String deptId);
	List<Employee> getAll();
}
