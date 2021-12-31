package service;

import java.util.List;

import persistence.DepartmentDto;

public interface DepartmentService {
	List<DepartmentDto> getAllDeptTotalBudget(int yearn);
	
	DepartmentDto getDepartmentBudgetHighInYear(int year);
}