package service;

import java.util.Objects;

import dao.EmployeeDaoImpl;
import persistence.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDaoImpl employeedao;

	public EmployeeServiceImpl() {
		employeedao = new EmployeeDaoImpl();
	}

	@Override
	public Employee signup(String email, String password) {
		Objects.requireNonNull(email, "email can't be null");
		Objects.requireNonNull(password, "password can't be null");
		return employeedao.signup(email, password);
	}

	@Override
	public Employee signin(String email, String password) {
		Objects.requireNonNull(email, "email can't be null");
		Objects.requireNonNull(password, "password can't be null");
		return employeedao.signin(email, password);
	}

}
