package service;

import dao.HibernateProjectDao;
import dao.ProjectDao;
import persistence.Project;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {


    private ProjectDao projectDao;
    public ProjectServiceImpl(){
        projectDao = new HibernateProjectDao();
    }
    @Override
    public List<Project> getProject(double budget) {
            return projectDao.getProject(budget);

    }
}
