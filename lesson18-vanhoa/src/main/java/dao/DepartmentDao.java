package dao;

import java.util.List;

import persistence.DepartmentDto;

public interface DepartmentDao {
	List<DepartmentDto> getTotalOfDepartmentInYear(int year);
	DepartmentDto getDepartmentHighestBudgetInYear(int year);
}
