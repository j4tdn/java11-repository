package dao;

import java.util.List;

import persistence.Department;
import persistence.DepartmentBudget;
import persistence.DepartmentBudgetYear;

public interface DepartmentDao {
	List<Department> getAll();
	
	List<DepartmentBudget> getSumBudgetOfDept(int sum);
	
	List<DepartmentBudgetYear> getBudgetbyYear(int year);
	
	List<DepartmentBudget> getProHaveBudMax();

}
