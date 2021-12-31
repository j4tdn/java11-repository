package dao;

import persistence.DepartmentDto;
import persistence.DepartmentMaxBudgetDto;

import java.util.List;

public interface DepartmentDao {
    List<DepartmentDto> getTotal(int year);
    List<DepartmentMaxBudgetDto> getMaxBudget(int year);
}
