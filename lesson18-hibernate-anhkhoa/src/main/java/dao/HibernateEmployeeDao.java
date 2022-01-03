package dao;

import org.hibernate.Session;
import org.hibernate.type.StringType;
import persistence.Employee;

import java.util.List;

public class HibernateEmployeeDao extends AbstractHibernateDao implements EmployeeDao{

    private Session session;

    public HibernateEmployeeDao() {
    }

    static String Q_GET_EMPLOYEE_BY_DEPT_ID = "select * from employee where dept_id= :id";

    @Override
    public List<Employee> getEmployeeByDept_Id(String dept_id) {
        List<Employee> list =  OpenSession().createNativeQuery(Q_GET_EMPLOYEE_BY_DEPT_ID,Employee.class)
                .setParameter("id",dept_id, StringType.INSTANCE).getResultList();
        return  list.size()>0 ? list : null;
    }
}
