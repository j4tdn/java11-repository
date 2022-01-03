package services;

import java.util.List;

import persistences.DepartmentDto;

public interface DepartmentService {
	List<DepartmentDto> getListTotalBudgetPerDepartmentIn(int year);
	
	DepartmentDto getHighestBudgetIn(int year);
}
