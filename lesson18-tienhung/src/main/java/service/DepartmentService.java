package service;

import java.util.List;

import persistence.DepartmentDto;

public interface DepartmentService {
	List<DepartmentDto> getDeptBudget(int year);
	DepartmentDto getDeptHighestBudget(int year);
}
