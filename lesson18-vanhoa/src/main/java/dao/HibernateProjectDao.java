package dao;

import java.util.List;

import persistence.Project;

public class HibernateProjectDao extends AbstractHibernateDao implements ProjectDao{
	private String Q_GET_BY_BUDGET = "SELECT * FROM project WHERE budget > :budget";
	
	public List<Project> getByBudget(Double budget) {
		return openSession().createNativeQuery(Q_GET_BY_BUDGET, Project.class).setParameter("budget", budget).getResultList();
	}
}
