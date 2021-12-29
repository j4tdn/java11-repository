package service;

import dao.DepartmentDao;
import dao.HibernateDepartmentDao;
import persistence.DepartmentBudgetDto;
import persistence.DepartmentListEmployeeDto;
import persistence.DepartmentTotalOfBudget;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentDao departmentDao;

    public DepartmentServiceImpl() {
        departmentDao = new HibernateDepartmentDao();
    }

    @Override
    public List<DepartmentListEmployeeDto> getEmployeesEachDepartment() {
        return departmentDao.getEmployeesEachDepartment();
    }

    @Override
    public List<DepartmentBudgetDto> getSumBudget() {
        return departmentDao.getSumBudget();
    }

    @Override
    public List<DepartmentTotalOfBudget> getListTotal() {
        return departmentDao.getListTotal();
    }

    @Override
    public List<DepartmentBudgetDto> getMaxBudget() {
        return departmentDao.getMaxBudget();
    }
}
