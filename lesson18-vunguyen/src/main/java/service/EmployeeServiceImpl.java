package service;

import dao.EmployeeDao;
import dao.HibernateEmployeeDao;
import persistent.Employee;
import persistent.EmployeeDto;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl() {
        employeeDao = new HibernateEmployeeDao();
    }

    @Override
    public List<Employee> get(String department_id) {
        return employeeDao.get(department_id);
    }

    @Override
    public List<EmployeeDto> getAllOrderByDeptId() {
        return employeeDao.getAllOrderByDeptId();
    }
}
