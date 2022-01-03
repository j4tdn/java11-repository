package service;

import java.util.List;

import dao.HiberanteProjectDao;
import dao.ProjectDao;
import persistence.Project;

public class ProjectServiceImpl implements ProjectService{
	
	private ProjectDao projectDao;
	
	public ProjectServiceImpl() {
		projectDao = new HiberanteProjectDao();
	}
	
	public List<Project> getProjectByBudgetGreater(double budget) {
		return projectDao.getProjectByBudgetGreater(budget);
	}
	
}