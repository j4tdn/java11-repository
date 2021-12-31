package dao;

import java.util.List;

import persistences.ProjectDto;

public interface ProjectDao {
	List<ProjectDto> getWithBudgetGreaterThan(double budget);
}
