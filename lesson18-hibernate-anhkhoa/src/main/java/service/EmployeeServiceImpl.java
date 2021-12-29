package service;

import dao.EmployeeDao;
import dao.HibernateEmployeeDao;
import persistence.Employee;

import java.util.List;
import java.util.Objects;

public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl() {
        employeeDao = new HibernateEmployeeDao();
    }

    @Override
    public List<Employee> getEmployeeByDept_Id(String dept_id) {
        Objects.requireNonNull(dept_id,"id khong the bang null");
        return employeeDao.getEmployeeByDept_Id(dept_id);
    }
}
