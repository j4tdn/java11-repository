package dao;

import java.util.List;

import org.hibernate.type.StringType;

import persistence.Employee;

public class HibernateEmployeeDao extends AbstractHibernateDao implements EmployeeDao{
	
	private static final String Q_GET_EMPLOYEE = 
			  "SELECT * \n"
			+ "FROM employee \n"
			+ "WHERE dept_id = :deptId";
	
	private static final String Q_GET_EMPLOYEE_SORT_DEMP_ID = 
			  "SELECT * \n"
			+ "FROM employee \n"
			+ "ORDER BY dept_id";

	public List<Employee> getEmployee(String deptId) {
		return openSession().createNativeQuery(Q_GET_EMPLOYEE, Employee.class)
				.setParameter("deptId", deptId, StringType.INSTANCE)
				.getResultList();
	}
	
	public List<Employee> getEmployeeSortDeptId() {
		return openSession().createNativeQuery(Q_GET_EMPLOYEE_SORT_DEMP_ID, Employee.class)
				.getResultList();
	}
	
}
