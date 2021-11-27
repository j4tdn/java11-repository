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
	public Employee signUp(String email, String password) {
		Objects.requireNonNull(email, "email cannot null");
		Objects.requireNonNull(password, "password cannot null");
		return employeeDao.signUp(email, password);
	}

	@Override
	public Employee signIn(String email, String password) {
		Objects.requireNonNull(email, "email cannot null");
		Objects.requireNonNull(password, "password cannot null");
		return employeeDao.signIn(email, password);
	}
}
