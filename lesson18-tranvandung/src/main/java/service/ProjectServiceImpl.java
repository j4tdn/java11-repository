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
	
	@Override
	public List<Project> getProjectByBudgetGreater(double budget) {
		return projectDao.getProjectByBudgetGreater(budget);
	}
	
}