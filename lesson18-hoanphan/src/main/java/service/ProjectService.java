package service;

import java.util.List;

import persistence.Department;
import persistence.DepartmentDto;
import persistence.Project;

public interface ProjectService {
	 List<Project> getAllProject(int budget);
}
