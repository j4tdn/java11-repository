package service;

import java.util.List;

import persistence.DepartmentDto;

public interface DepartmentService {
	List<DepartmentDto> getDeptTotalBudget(int year);
	
	DepartmentDto getDeptHighestBudget(int year);
}