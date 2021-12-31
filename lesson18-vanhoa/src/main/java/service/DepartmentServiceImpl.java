package service;

import java.util.List;

import dao.DepartmentDao;
import dao.HibernateDepartmentImpl;
import persistence.DepartmentDto;

public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentDao departmentDao;
	
	public DepartmentServiceImpl() {
		departmentDao = new HibernateDepartmentImpl();
	}
	
	public List<DepartmentDto> getTotalOfDepartmentInYear(int year) {
		return departmentDao.getTotalOfDepartmentInYear(year);
	}
	
	public DepartmentDto getDepartmentHighestBudgetInYear(int year) {
		return departmentDao.getDepartmentHighestBudgetInYear(year);
	}
}
