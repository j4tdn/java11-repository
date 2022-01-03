package service;

import java.util.List;

import dao.DepartmentDao;
import dao.HibernateDepartmentDao;
import persistence.DepartmentDto;

public class DepartmentServiceImpl implements DepartmentService{
	private DepartmentDao departmentDao;
	
	public DepartmentServiceImpl() {
		departmentDao = new HibernateDepartmentDao();
	}

	public List<DepartmentDto> getTotalBudgetOfDept(int year) {
		return departmentDao.getTotalBudgetOfDept(year);
	}

	public DepartmentDto getDepartmentBudgetHighInYear(int year) {
		return departmentDao.getDepartmentBudgetHighInYear(year);
	}
	
	
}
