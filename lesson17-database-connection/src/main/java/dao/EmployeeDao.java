package dao;

import persistence.Employee;

public interface EmployeeDao {
	Employee signup(String username, String password);
}
