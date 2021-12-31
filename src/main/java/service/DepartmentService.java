package service;

import persistence.DepartmentDto;
import persistence.DepartmentMaxBudgetDto;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> getTotal(int year);
    List<DepartmentMaxBudgetDto> getMaxBudget(int year);

}
