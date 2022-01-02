package dao;

import persistent.Employee;
import persistent.EmployeeDto;

import java.util.List;

public interface EmployeeDao {
    List<Employee> get(String department_id);

    List<EmployeeDto> getAllOrderByDeptId();
}
