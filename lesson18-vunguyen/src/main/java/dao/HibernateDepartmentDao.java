package dao;

import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.StringType;
import persistent.DepartmentDto;

import java.util.List;

public class HibernateDepartmentDao extends AbstractHibernateDao implements DepartmentDao {

    private static final String Q_GET_ALL_DEPARTMENT_TOTAL_BUDGET = "SELECT dept_name,\n" +
                                                                    "       group_concat(concat(pro_name, ' ', budget)) project_details,\n" +
                                                                    "       sum(budget) budget\n" +
                                                                    "FROM department dept\n" +
                                                                    "JOIN project pj\n" +
                                                                    "ON dept.dept_id = pj.dept_id\n" +
                                                                    "GROUP BY dept.dept_id";
    private static final String Q_GET_HIGHEST_BUDGET_DEPARTMENT = "SELECT dept_name,\n" +
                                                                  "       pro_name project_details,\n" +
                                                                  "       budget\n" +
                                                                  "FROM department dept\n" +
                                                                  "JOIN project pj\n" +
                                                                  "ON dept.dept_id = pj.dept_id\n" +
                                                                  "ORDER BY budget DESC\n" +
                                                                  "LIMIT 1";


    @SuppressWarnings({"unchecked", "deprecation"})
    @Override
    public List<DepartmentDto> getAllDepartmentTotalBudget() {
        return openSession().createNativeQuery(Q_GET_ALL_DEPARTMENT_TOTAL_BUDGET)
                            .addScalar("dept_name", StringType.INSTANCE)
                            .addScalar("project_details", StringType.INSTANCE)
                            .addScalar("budget", DoubleType.INSTANCE)
                            .setResultTransformer(Transformers.aliasToBean(DepartmentDto.class))
                            .getResultList();
    }

    @SuppressWarnings("deprecation")
	@Override
    public DepartmentDto getHighestBudgetDepartment() {
        return (DepartmentDto) openSession().createNativeQuery(Q_GET_HIGHEST_BUDGET_DEPARTMENT)
                                            .addScalar("dept_name", StringType.INSTANCE)
                                            .addScalar("project_details", StringType.INSTANCE)
                                            .addScalar("budget", DoubleType.INSTANCE)
                                            .setResultTransformer(Transformers.aliasToBean(DepartmentDto.class))
                                            .uniqueResult();
    }
}
