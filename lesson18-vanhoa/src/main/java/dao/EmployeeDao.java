package dao;

import java.util.List;

import persistence.Employee;

public interface EmployeeDao {
	List<Employee> getAll();
	List<Employee> getAllAndSortByDeptId();
}
