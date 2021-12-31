package dao;

import java.util.List;
import org.hibernate.type.DoubleType;
import persistence.Project;

public class HiberanteProjectDao extends AbstractHibernateDao implements ProjectDao {

	private final String G_PRJ_BY_BG_GREATER = "SELECT *\n" + "FROM project\n" + "WHERE budget > :budget";

	@Override
	public List<Project> getProjectByBudgetGreater(double budget) {
		return openSession().createNativeQuery(G_PRJ_BY_BG_GREATER, Project.class)
				.setParameter("budget", budget, DoubleType.INSTANCE).getResultList();
	}

}