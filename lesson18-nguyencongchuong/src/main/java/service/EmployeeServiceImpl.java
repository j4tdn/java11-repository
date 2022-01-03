package service;

import java.util.List;
import java.util.Objects;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import persistence.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDao;
	
	public EmployeeServiceImpl() {
		employeeDao = new EmployeeDaoImpl();
	}
	
	public List<Employee> getEmloyeeById(String id) {
		Objects.requireNonNull(id);
		return employeeDao.getEmloyeeById(id);
	}

	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

}
