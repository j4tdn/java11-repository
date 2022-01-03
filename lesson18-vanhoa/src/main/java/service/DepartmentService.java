package service;

import java.util.List;

import persistence.DepartmentDto;

public interface DepartmentService {
	List<DepartmentDto> getTotalOfDepartmentInYear(int year);
	DepartmentDto getDepartmentHighestBudgetInYear(int year);
}
