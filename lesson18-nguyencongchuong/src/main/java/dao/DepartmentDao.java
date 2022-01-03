package dao;

import java.util.List;

import persistence.DepartmentDto;

public interface DepartmentDao {
	List<DepartmentDto> totalBudgetDepartment(int year);
	
	DepartmentDto getDeparmentHighestBudget(int year);
}
