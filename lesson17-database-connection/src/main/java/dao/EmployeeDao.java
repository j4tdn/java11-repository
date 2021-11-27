package dao;

import persistence.Employee;

public interface EmployeeDao {
	Employee signUp(String username, String password);
	Employee signIn(String username, String password);
}
