package dao;

import java.util.List;

import persistence.DepartmentDto;

public interface DepartmentDao {
	List<DepartmentDto> getDeptBudget(int year);
	DepartmentDto getDeptHighestBudget(int year);
}