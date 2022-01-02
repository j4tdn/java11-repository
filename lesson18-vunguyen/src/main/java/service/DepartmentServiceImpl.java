package service;

import dao.DepartmentDao;
import dao.HibernateDepartmentDao;
import persistent.DepartmentDto;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentDao departmentDao;

    public DepartmentServiceImpl() {
        departmentDao = new HibernateDepartmentDao();
    }

    @Override
    public List<DepartmentDto> getAllDepartmentTotalBudget() {
        return departmentDao.getAllDepartmentTotalBudget();
    }

    @Override
    public DepartmentDto getHighestBudgetDepartment() {
        return departmentDao.getHighestBudgetDepartment();
    }
}
