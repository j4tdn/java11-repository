package services;

import java.util.Comparator;
import java.util.List;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import persistences.DepartmentDto;

public class DepartmentSerivceImpl implements DepartmentService{
	private DepartmentDao departmentDao;
	
	public DepartmentSerivceImpl() {
		departmentDao = new DepartmentDaoImpl();
	}
	public List<DepartmentDto> getListTotalBudgetPerDepartmentIn(int year) {
		return departmentDao.getListTotalBudgetPerDepartmentIn(year);
	}
	public DepartmentDto getHighestBudgetIn(int year) {
		List<DepartmentDto> list = departmentDao.getListTotalBudgetPerDepartmentIn(year);		
		return list.stream().max(Comparator.comparing(DepartmentDto::getTotal)).get();
	}

}
