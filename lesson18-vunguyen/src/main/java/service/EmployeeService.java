package service;

import persistent.Employee;
import persistent.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<Employee> get(String department_id);

    List<EmployeeDto> getAllOrderByDeptId();

}
