package dao;

import org.hibernate.type.StringType;
import persistence.Employees;

import java.util.List;

public class HibernateEmployeesDao extends AbstractHibernateDao implements EmployeesDao {

    private static final String Q_GET_ALL_BY_DEPT_ID = "SELECT * FROM  employee WHERE dept_id = :dId ";

    private static final String Q_GET_ALL_DEPT_ID_ASC = "SELECT * FROM employee ORDER BY dept_id ";


    public List<Employees> getAll(String dId) {
        return openSession().createNativeQuery(Q_GET_ALL_BY_DEPT_ID, Employees.class)
                .setParameter("dId", dId, StringType.INSTANCE)
                .getResultList();
    }

    @Override
    public List<Employees> getEmployee() {
        return openSession().createNativeQuery(Q_GET_ALL_DEPT_ID_ASC,Employees.class).getResultList();
    }


}
