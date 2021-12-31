package service;

import java.util.List;

import persistence.Project;

public interface ProjectService {
	List<Project> getProject(double budget);
}
