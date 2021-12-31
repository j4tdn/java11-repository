package dao;

import java.util.List;

import persistence.DepartmentDto;

public interface DepartmentDao {
	List<DepartmentDto> getAllDeptTotalBudget(int year);

	DepartmentDto getDepartmentBudgetHighInYear(int year);
}
