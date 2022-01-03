package dao;

import java.util.List;

import persistence.Employee;

public interface EmployeeDao {
	List<Employee> getEmloyeeById(String id);
	
	List<Employee> getAll();
}
