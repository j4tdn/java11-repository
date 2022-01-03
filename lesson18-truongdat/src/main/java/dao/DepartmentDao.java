package dao;

import java.util.List;

import persistences.DepartmentDto;

public interface DepartmentDao {
	List<DepartmentDto> getListTotalBudgetPerDepartmentIn(int year);
}
