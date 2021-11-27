package service;

import persistence.Employee;

public interface EmployeeService {
    Employee singup(String email, String password);

    Employee signin(String email, String password);
}
