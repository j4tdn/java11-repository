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
		Objects.requireNonNull(email, "email can not be null ");
		Objects.requireNonNull(password, "email can not be null ");
		return employeeDao.signup(email, password);
	}
	

}
