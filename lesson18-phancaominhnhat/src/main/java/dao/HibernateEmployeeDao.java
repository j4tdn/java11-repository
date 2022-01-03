package dao;

import java.util.List;

import org.hibernate.type.StringType;

import persistence.Employee;

public class HibernateEmployeeDao extends AbstractHibernateDao implements EmployeeDao{
	private final String GET_EMP_BY_DEPT_ID = "SElECT * \n"
											 + "FROM employee\n"
											 + "WHERE dept_id = :deptId";
	
	private final String GET_ALL_EMP = "SElECT * \n"
			   + "FROM employee\n"
			   + "ORDER BY dept_id";
	
	public List<Employee> getEmployeeByDeptId(String deptId) {
		return openSession()
				.createNativeQuery(GET_EMP_BY_DEPT_ID, Employee.class)
				.setParameter("deptId", deptId, StringType.INSTANCE)
				.getResultList();
	}
	
	public List<Employee> getAll() {
		return openSession().createNativeQuery(GET_ALL_EMP, Employee.class).getResultList();	
	}

}
