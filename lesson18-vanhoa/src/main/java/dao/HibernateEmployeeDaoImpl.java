package dao;

import java.util.List;

import persistence.Employee;

public class HibernateEmployeeDaoImpl extends AbstractHibernateDao implements EmployeeDao {
	private String Q_GET_ALL = "SELECT * FROM employee";
	private String Q_GET_ALL_SORTING_BY_DEPT_ID = "SELECT * FROM employee ORDER BY dept_id";
	
	public List<Employee> getAll() {
		
		return openSession().createNativeQuery(Q_GET_ALL, Employee.class).getResultList();
	}
	
	public List<Employee> getAllAndSortByDeptId() {
		return openSession().createNativeQuery(Q_GET_ALL_SORTING_BY_DEPT_ID, Employee.class).getResultList();
	}
}
