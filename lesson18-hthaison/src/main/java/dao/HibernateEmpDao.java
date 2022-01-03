package dao;

import java.util.List;

import org.hibernate.type.StringType;

import persistence.Employee;

public class HibernateEmpDao extends AbstractHibernateDao implements EmployeeDao{
	
	private static final String Q_GET_EMP_ID = "SELECT * FROM employee "
							+ "WHERE dept_id = :id";
	private static final String  Q_GET_ALL_EMP = "SELECT * FROM employee "
							+ "ORDER BY dept_id ASC";
	public List<Employee> getEmployeeByDept_ID(String dept_id){
		return  openSession().createNativeQuery(Q_GET_EMP_ID,Employee.class)
							.setParameter("id",dept_id,StringType.INSTANCE)
							.getResultList();
	}
	public List<Employee> getAll(){
		return openSession().createNativeQuery(Q_GET_ALL_EMP,Employee.class)
							.getResultList();
	}

}
