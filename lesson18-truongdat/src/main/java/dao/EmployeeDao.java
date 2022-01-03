package dao;

import java.util.List;

import persistences.Employee;

public interface EmployeeDao {
	List<Employee> getByDeptId(String deptId);
	
	List<Employee> getAll();
}
