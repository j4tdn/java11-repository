package service;

import persistent.ProjectDto;

import java.util.List;

public interface ProjectService {
    List<ProjectDto> getAllBudgetGreaterThan400();

}
