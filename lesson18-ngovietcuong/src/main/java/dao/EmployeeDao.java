package dao;

import java.util.List;

import persistence.Employee;

public interface EmployeeDao {
	List<Employee> getEmployee(String deptId);
	
	List<Employee> getEmployeeSortDeptId();
}
