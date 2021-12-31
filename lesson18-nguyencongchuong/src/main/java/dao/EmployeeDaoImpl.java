package dao;

import java.util.List;

import org.hibernate.type.StringType;

import persistence.Employee;

public class EmployeeDaoImpl extends AbstractHibernateDao implements EmployeeDao{

	private final String GET_EMP_BY_ID = "SElECT * FROM employee WHERE dept_id = :dptId";
	private final String GET_ALL = "SElECT * FROM employee ORDER BY dept_id";


	public List<Employee> getEmloyeeById(String id) {
		return openSession().createNativeQuery(GET_EMP_BY_ID, Employee.class)
				.setParameter("dptId", id, StringType.INSTANCE).getResultList();
	}

	public List<Employee> getAll() {
		return openSession().createNativeQuery(GET_ALL, Employee.class).getResultList();
	}

}
