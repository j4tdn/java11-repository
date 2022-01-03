package service;

import java.util.List;

import persistence.Employees;

public interface EmployeeService {
	List<Employees> getEmloyeeById (String deptId);
    List<Employees> getAllEmp();
}