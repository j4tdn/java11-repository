package services;

import java.util.List;

import persistences.ProjectDto;

public interface ProjectService {
	List<ProjectDto> getWithBudgetGreaterThan(double budget);
}
