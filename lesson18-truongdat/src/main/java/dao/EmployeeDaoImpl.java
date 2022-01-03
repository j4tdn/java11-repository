package dao;

import java.util.List;

import org.hibernate.Session;

import persistences.Employee;

public class EmployeeDaoImpl extends AbstractHibernateDao implements EmployeeDao{
	private static final String Q_GET_EMP = "SELECT * FROM Employee WHERE dept_id = :dept_id";
	private static final String Q_GET_ALL = "SELECT * FROM Employee order by dept_id asc;";
	
	public List<Employee> getByDeptId(String deptId) {
		Session session = openSession();
		return session.createNativeQuery(Q_GET_EMP, Employee.class)
				.setParameter("dept_id", deptId)
				.getResultList();
	}

	public List<Employee> getAll() {
		return openSession().createNativeQuery(Q_GET_ALL, Employee.class).getResultList();
	}
}
