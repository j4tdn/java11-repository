package dao;

import java.util.List;

import org.hibernate.type.DoubleType;

import persistence.Project;

public class ProjectDaoImpl extends AbstractHibernateDao implements ProjectDao{

	private final String GET_PROJECT = "SELECT * FROM project WHERE budget > :budget";
	
	public List<Project> getProject(double budget) {
		return openSession().createNativeQuery(GET_PROJECT, Project.class)
				.setParameter("budget", budget, DoubleType.INSTANCE).getResultList();
	}

}
