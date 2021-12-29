package dao;

import persistence.DepartmentBudgetDto;
import persistence.DepartmentListEmployeeDto;
import persistence.DepartmentTotalOfBudget;

import java.util.List;

public interface DepartmentDao {
    List<DepartmentListEmployeeDto> getEmployeesEachDepartment();

    List<DepartmentBudgetDto> getSumBudget();

    List<DepartmentTotalOfBudget> getListTotal();

    List<DepartmentBudgetDto> getMaxBudget();
}
