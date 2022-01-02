package dao;

import persistent.ProjectDto;

import java.util.List;

public interface ProjectDao {
    List<ProjectDto> getAllBudgetGreaterThan400();
}
