package dao;

import java.util.List;

import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.StringType;

import persistences.ProjectDto;

public class ProjectDaoImpl extends AbstractHibernateDao implements ProjectDao{
	private static String Q_GET_PROJECTS_WITH_BUDGET_GREATER_THAN = 
			"SELECT d.dept_name, p.pro_name, p.budget\n"
			+ "FROM Project p \n"
			+ "JOIN department d\n"
			+ "ON p.dept_id = d.dept_id \n"
			+ "WHERE budget > :budget";
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<ProjectDto> getWithBudgetGreaterThan(double budget) {
		return openSession().createNativeQuery(Q_GET_PROJECTS_WITH_BUDGET_GREATER_THAN)
				.setParameter("budget", budget)
				.addScalar(ProjectDto.DEPT_NAME, StringType.INSTANCE)
				.addScalar(ProjectDto.PRO_NAME, StringType.INSTANCE)
				.addScalar(ProjectDto.BUDGET, DoubleType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(ProjectDto.class))
				.getResultList();
	}
	
}
