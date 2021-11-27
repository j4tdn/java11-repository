package dao;

import persistence.Employee;

public interface EmployeeDao {
	Employee signup(String email, String password);
	Employee singin(String email, String password);
}
