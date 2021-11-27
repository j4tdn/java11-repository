package service;

import persistence.Employee;

public interface EmployeeService {
	Employee signUp(String email, String password);
	Employee signIn(String email, String password);
}
