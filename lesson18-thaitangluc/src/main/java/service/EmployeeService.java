package service;

import java.util.List;

import persistence.Employee;

public interface EmployeeService {
	List<Employee> getByDeptId(String deptId);
}
