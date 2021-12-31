package dao;

import persistence.Employees;

import java.util.List;

public interface EmployeeDao {
    List<Employees> getEmloyeeById (String deptId);
    List<Employees> getAllEmp ();
}