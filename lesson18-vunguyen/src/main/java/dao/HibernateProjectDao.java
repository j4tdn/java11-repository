package dao;

import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.StringType;
import persistent.ProjectDto;

import java.util.List;

public class HibernateProjectDao extends AbstractHibernateDao implements ProjectDao {

    private static final String Q_GET_ALL_BUDGET_GREATER_THAN_400 = "SELECT department.dept_name,\n" +
                                                                    "       project.pro_name,\n" +
                                                                    "       project.budget\n" +
                                                                    "FROM project\n" +
                                                                    "JOIN department\n" +
                                                                    "ON project.dept_id = department.dept_id\n" +
                                                                    "WHERE budget > 400";

    @SuppressWarnings({"unchecked", "deprecation"})
    @Override
    public List<ProjectDto> getAllBudgetGreaterThan400() {
        return openSession().createNativeQuery(Q_GET_ALL_BUDGET_GREATER_THAN_400)
                            .addScalar("dept_name", StringType.INSTANCE)
                            .addScalar("pro_name", StringType.INSTANCE)
                            .addScalar("budget", DoubleType.INSTANCE)
                            .setResultTransformer(Transformers.aliasToBean(ProjectDto.class))
                            .getResultList();
    }
}
