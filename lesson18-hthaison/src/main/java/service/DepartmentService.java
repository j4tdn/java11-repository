package service;

import java.util.List;

import persistence.Department;
import persistence.DepartmentBudget;
import persistence.DepartmentBudgetYear;

public interface DepartmentService {
	
	List<Department> getAll();
	
	List<DepartmentBudget> getSumBudgetofDept(int sumBud);
	
	List<DepartmentBudgetYear> getBudgetbyYear(int year);
	
	List<DepartmentBudget> getProHaveBudMax();

	
}
