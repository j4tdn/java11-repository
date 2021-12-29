package dao;

import java.util.List;

import org.hibernate.type.DoubleType;

import persistence.Project;

public class HibernateProjectDao extends AbstractHibernateDao implements ProjectDao {
	private final String GET_PRO_BY_BG_GREATER = "SELECT *\n"
			 + "FROM project\n"
			 + "WHERE budget > :budget";

	public List<Project> getProjectByBudgetGreater(double budget) {
		return openSession().createNativeQuery(GET_PRO_BY_BG_GREATER, Project.class)
				.setParameter("budget", budget, DoubleType.INSTANCE).getResultList();
	}
}	
