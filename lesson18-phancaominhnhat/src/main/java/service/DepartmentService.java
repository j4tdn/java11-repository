package service;

import java.util.List;

import persistence.DepartmentDto;

public interface DepartmentService {
	List<DepartmentDto> getTotalBudgetOfDept(int year);

	DepartmentDto getDepartmentBudgetHighInYear(int year);
}
