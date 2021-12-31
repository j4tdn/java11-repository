package service;

import java.util.List;
import java.util.Objects;

import dao.ProjectDao;
import dao.ProjectDaoImpl;
import persistence.Project;

public class ProjectServiceImpl implements ProjectService{

	private static ProjectDao projectDao;
	
	public ProjectServiceImpl() {
		projectDao = new ProjectDaoImpl();
	}
	
	public List<Project> getProject(double budget) {
		Objects.requireNonNull(budget);
		return projectDao.getProject(budget);
	}

}
