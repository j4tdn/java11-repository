package dao;

import java.util.List;

import org.hibernate.type.DoubleType;

import persistence.Project;

public class HiberanteProjectDao extends AbstractHibernateDao implements ProjectDao{
	
	private final String G_PROJECT_BY_BUDGET_GREATER = 
			   "SELECT * \n"
			 + "FROM project \n"
			 + "WHERE budget > :budget";
	
	public List<Project> getProjectByBudgetGreater(double budget) {
		return openSession().createNativeQuery(G_PROJECT_BY_BUDGET_GREATER, Project.class)
				.setParameter("budget", budget, DoubleType.INSTANCE).getResultList();
	}
}