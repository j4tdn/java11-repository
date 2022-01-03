package service;

import java.util.List;

import dao.DepartmentDao;
import dao.HibernateDepartmentDao;
import persistence.Department;
import persistence.DepartmentBudget;
import persistence.DepartmentBudgetYear;

public class DepartmentServiceImpl implements DepartmentService {
	
	private static DepartmentDao departmentDao;
	public DepartmentServiceImpl() {
		departmentDao = new HibernateDepartmentDao();
	}
	public List<Department> getAll() {
		return departmentDao.getAll();
	}
	public List<DepartmentBudget> getSumBudgetofDept(int sumBud) {
		return departmentDao.getSumBudgetOfDept(sumBud);
	}
	public List<DepartmentBudgetYear> getBudgetbyYear(int year) {
		return departmentDao.getBudgetbyYear(year);
	}
	public List<DepartmentBudget> getProHaveBudMax() {
		return departmentDao.getProHaveBudMax();
	}

}
