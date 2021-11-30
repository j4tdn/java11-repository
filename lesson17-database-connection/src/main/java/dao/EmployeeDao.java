package dao;

import persistence.Employee;

public interface EmployeeDao {
	Employee signup(String username, String password);
	Employee signin(String username, String password);
}
