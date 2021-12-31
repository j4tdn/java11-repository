package service;

import java.util.List;
import java.util.Objects;

import dao.DeparmentDaoImpl;
import dao.DepartmentDao;
import persistence.DepartmentDto;

public class DeparmentServiceImpl implements DepartmentService{
	
	private static DepartmentDao departmentDao;
	
	public DeparmentServiceImpl() {
		departmentDao = new DeparmentDaoImpl();
	}

	public List<DepartmentDto> totalBudgetDepartment(int year) {
		Objects.requireNonNull(year);
		return departmentDao.totalBudgetDepartment(year);
	}

	public DepartmentDto getDeparmentHighestBudget(int year) {
		Objects.requireNonNull(year);
		return departmentDao.getDeparmentHighestBudget(year);
	}

}
