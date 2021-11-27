package service;

import java.util.Objects;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import persistence.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDao employeeDao;
	
	public EmployeeServiceImpl() {
		employeeDao = new EmployeeDaoImpl();
	}

	@Override
	public Employee signup(String email, String password) {
		Objects.requireNonNull(email);
		Objects.requireNonNull(password);
		return employeeDao.signup(email, password);
	}

	@Override
	public Employee signin(String email, String password) {
		return employeeDao.signin(email, password);
	}

}
