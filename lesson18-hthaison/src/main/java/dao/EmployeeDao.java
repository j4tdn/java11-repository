package dao;

import java.util.List;

import persistence.Employee;

public interface EmployeeDao {
	List<Employee> getEmployeeByDept_ID(String dept_id);
	List<Employee> getAll();
}
