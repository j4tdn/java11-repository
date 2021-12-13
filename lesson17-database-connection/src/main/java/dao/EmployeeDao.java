package dao;

import persistence.Employee;

public interface EmployeeDao {
	Employee signup(String email,String password);
	
	Employee signin(String email,String password);
}