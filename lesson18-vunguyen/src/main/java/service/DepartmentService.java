package service;

import persistent.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> getAllDepartmentTotalBudget();

    DepartmentDto getHighestBudgetDepartment();

}
