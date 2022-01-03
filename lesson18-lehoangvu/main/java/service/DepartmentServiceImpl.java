package service;

import dao.DepartmentDao;
import dao.HibernateDepartmentDao;
import persistence.DepartmentDto;
import persistence.DepartmentMaxBudgetDto;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService{
    private DepartmentDao departmentDao;



    public DepartmentServiceImpl(){
        departmentDao = new HibernateDepartmentDao();
    }

    @Override
    public List<DepartmentDto> getTotal(int year) {
        return departmentDao.getTotal(year);
    }

    @Override
    public List<DepartmentMaxBudgetDto> getMaxBudget(int year) {
        return departmentDao.getMaxBudget(year);
    }
}
