package dao;

import org.hibernate.type.DoubleType;
import persistence.Project;

import java.util.List;

public class HibernateProjectDao extends AbstractHibernateDao implements ProjectDao {
    private static final String  Q_GET_PROJECT = "SELECT * FROM project WHERE budget >:budget";


    public List<Project> getProject(double budget) {
        return openSession().createNativeQuery(Q_GET_PROJECT, Project.class)
                            .setParameter("budget",budget,DoubleType.INSTANCE)
                            .getResultList();
    }
}
