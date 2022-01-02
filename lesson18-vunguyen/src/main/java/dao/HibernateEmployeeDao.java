package dao;

import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import persistent.Employee;
import persistent.EmployeeDto;

import java.util.List;

public class HibernateEmployeeDao extends AbstractHibernateDao implements EmployeeDao {

    private static final String Q_GET_BY_DEPARTMENT_ID = "SELECT * FROM employee WHERE dept_id = :dept_id";
    private static final String Q_GET_ALL_SORT_BY_DEPT_ID = "SELECT emp.emp_id,\n" +
                                                            "       emp.emp_name,\n" +
                                                            "       emp.age,\n" +
                                                            "       emp.salary,\n" +
                                                            "       dept.dept_id,\n" +
                                                            "       dept.dept_name\n" +
                                                            "FROM employee emp\n" +
                                                            "JOIN department dept\n" +
                                                            "ON emp.dept_id = dept.dept_id\n" +
                                                            "ORDER BY dept_id";

    @Override
    public List<Employee> get(String department_id) {
        return openSession().createNativeQuery(Q_GET_BY_DEPARTMENT_ID, Employee.class)
                            .setParameter("dept_id", department_id)
                            .getResultList();
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @Override
    public List<EmployeeDto> getAllOrderByDeptId() {
        return openSession().createNativeQuery(Q_GET_ALL_SORT_BY_DEPT_ID)
                            .addScalar("emp_id", StringType.INSTANCE)
                            .addScalar("emp_name", StringType.INSTANCE)
                            .addScalar("age", IntegerType.INSTANCE)
                            .addScalar("dept_id", StringType.INSTANCE)
                            .addScalar("dept_name", StringType.INSTANCE)
                            .setResultTransformer(Transformers.aliasToBean(EmployeeDto.class))
                            .getResultList();
    }
}
