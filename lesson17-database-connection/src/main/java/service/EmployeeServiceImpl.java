package service;

import java.util.Objects;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import persistence.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	public EmployeeServiceImpl() {
		employeeDao = new EmployeeDaoImpl();
	}

	@Override
	public Employee signup(String email, String password) {
		Objects.requireNonNull(email, "email cannot be null");
		Objects.requireNonNull(password, "password cannot be null");
		return employeeDao.signup(email, password);
	}
	
	@Override
	public Employee signin(String email, String password) {
		Objects.requireNonNull(email, "email cannot be null");
		Objects.requireNonNull(password, "password cannot be null");
		return employeeDao.singin(email, password);
	}
}