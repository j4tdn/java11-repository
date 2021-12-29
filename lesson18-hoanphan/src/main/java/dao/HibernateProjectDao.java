package dao;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import persistence.Department;
import persistence.DepartmentDto;
import persistence.Project;

public class HibernateProjectDao extends AbstractHibernateDao implements ProjectDao{
	
	private final String Q_GET_ALL_PROJECT_GR = "select * from project \r\n"
			+ "where budget > :budget";
	
	public List<Project> getAllProject(int budget) {
		return openSession().createNativeQuery(Q_GET_ALL_PROJECT_GR, Project.class)
				.setParameter("budget", budget, IntegerType.INSTANCE)
				.getResultList();
	}
}
