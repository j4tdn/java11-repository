package service;

import java.util.List;

import persistence.Employee;

public interface EmployeeService {
	List<Employee> getEmpByDeptId(String dptId);
	
	List<Employee> getAll();
}
