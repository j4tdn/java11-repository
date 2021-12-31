package dao;

import java.util.List;

import persistence.Employee;

public interface EmployeeDao {
	List<Employee> getByDeptId(String deptId);
}
