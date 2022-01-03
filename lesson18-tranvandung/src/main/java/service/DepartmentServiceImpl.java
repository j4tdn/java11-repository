package service;

import java.util.List;
import dao.DepartmentDao;
import dao.HibernateDepartmentDao;
import persistence.DepartmentDto;

public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDao departmentDao;
	
	public DepartmentServiceImpl() {
		departmentDao = new HibernateDepartmentDao();
	}

	@Override
	public List<DepartmentDto> getAllDeptTotalBudget(int year) {
		return departmentDao.getAllDeptTotalBudget(year);
	}

	@Override
	public DepartmentDto getDepartmentBudgetHighInYear(int year) {
		return departmentDao.getDepartmentBudgetHighInYear(year);
	}
}