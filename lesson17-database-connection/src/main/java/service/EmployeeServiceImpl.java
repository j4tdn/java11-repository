package service;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import persistence.Employee;

import java.util.Objects;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    public EmployeeServiceImpl() {
        employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public Employee singup(String email, String password) {
        Objects.requireNonNull(email, "email cannot be null");
        Objects.requireNonNull(password, "password cannot be null");
        return employeeDao.signup(email, password);
    }

    @Override
    public Employee signin(String email, String password) {
        Objects.requireNonNull(email, "email cannot be null");
        Objects.requireNonNull(password, "password cannot be null");
        return  employeeDao.signin(email, password);
    }
}
