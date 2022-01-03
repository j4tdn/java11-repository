package services;

import java.util.List;

import dao.ProjectDao;
import dao.ProjectDaoImpl;
import persistences.ProjectDto;

public class ProjectSerivceImpl implements ProjectService{
	
	private ProjectDao projectDao;
	
	public ProjectSerivceImpl() {
		projectDao = new ProjectDaoImpl();
	}

	public List<ProjectDto> getWithBudgetGreaterThan(double budget) {
		return projectDao.getWithBudgetGreaterThan(budget);
	}
	
}
