package services;

import java.util.List;

import persistences.Employee;

public interface EmployeeService {
	List<Employee> getByDeptId(String deptId);
	
	List<Employee> getAll();
}
