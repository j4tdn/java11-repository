package service;

import java.util.List;

import persistence.Employee;

public interface EmployeeService {
	List<Employee> getEmloyeeById(String id);
	
	List<Employee> getAll();
}
