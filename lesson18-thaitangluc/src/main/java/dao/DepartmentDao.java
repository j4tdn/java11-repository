package dao;

import java.util.List;

import persistence.DepartmentDto;

public interface DepartmentDao {
	List<DepartmentDto> getDeptTotalBudget(int year);
	
	DepartmentDto getDeptHighestBudget(int year);
}