package service;

import java.util.List;

import dao.DepartmentDao;
import dao.HibernateDepartmentDao;
import persistence.DepartmentDto;

public class DepartmentServiceImpl implements DepartmentService{
	
	private DepartmentDao deptDao;
	
	public DepartmentServiceImpl() {
		deptDao = new HibernateDepartmentDao();
	}
	public List<DepartmentDto> getDeptBudget(int year) {
		return deptDao.getDeptBudget(year);
	}
	public DepartmentDto getDeptHighestBudget(int year) {
		return deptDao.getDeptHighestBudget(year);
	}

}