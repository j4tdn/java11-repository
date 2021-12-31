package service;

import dao.EmployeesDao;
import dao.HibernateEmployeesDao;
import persistence.Employees;

import java.util.List;

public class EmployeesServiceImpl implements EmployeesService{
    private EmployeesDao employeesDao;

    public EmployeesServiceImpl() {
        employeesDao = new HibernateEmployeesDao();
    }

    public List<Employees> getAll(String dId) {
        return employeesDao.getAll( dId);
    }

    @Override
    public List<Employees> getEmployee() {
        return employeesDao.getEmployee();
    }


}
