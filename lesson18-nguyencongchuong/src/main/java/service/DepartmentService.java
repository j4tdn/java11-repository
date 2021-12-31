package service;

import java.util.List;

import persistence.DepartmentDto;

public interface DepartmentService {
	List<DepartmentDto> totalBudgetDepartment(int year);
	
	DepartmentDto getDeparmentHighestBudget(int year);
}
