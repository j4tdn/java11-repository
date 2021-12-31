package dao;

import persistence.Employees;

import java.util.List;

public interface EmployeesDao {

    List<Employees> getAll(String dId);

    List<Employees> getEmployee();
}
