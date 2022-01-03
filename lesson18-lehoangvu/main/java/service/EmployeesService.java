package service;

import persistence.Employees;

import java.util.List;

public interface EmployeesService {
    List<Employees> getAll(String dId);
    List<Employees> getEmployee();
}
