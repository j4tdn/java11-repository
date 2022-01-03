package service;

import dao.HibernateProjectDao;
import dao.ProjectDao;
import persistent.ProjectDto;

import java.util.List;

public class ProjectServiceImpl implements ProjectService{
    private final ProjectDao projectDao;

    public ProjectServiceImpl() {
        projectDao = new HibernateProjectDao();
    }

    @Override
    public List<ProjectDto> getAllBudgetGreaterThan400() {
        return projectDao.getAllBudgetGreaterThan400();
    }
}
