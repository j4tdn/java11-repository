package dao;

import persistent.DepartmentDto;

import java.util.List;

public interface DepartmentDao {
    List<DepartmentDto> getAllDepartmentTotalBudget();

    DepartmentDto getHighestBudgetDepartment();
}
