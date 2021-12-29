package dao;

import persistence.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getEmployeeByDept_Id(String dept_id);

}
