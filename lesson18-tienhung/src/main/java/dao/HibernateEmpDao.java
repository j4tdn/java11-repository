package dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import persistence.Employees;

public class HibernateEmpDao extends AbstractHibernateDao implements EmployeeDao {

	private static final String Q_GET_EMP_ID = "select * from employee e \n"
			+ "where dept_id = :dept_id";
	
	private static final String Q_GET_EMP_All = "select * from employee \n"
			+ "order by dept_id;";
	

	public List<Employees> getEmloyeeById (String deptId) {
		return openSession().createNativeQuery(Q_GET_EMP_ID, Employees.class)
				.setParameter("dept_id",deptId,StringType.INSTANCE)
				.getResultList();
	}
	public List<Employees> getAllEmp() {
		return openSession().createNativeQuery(Q_GET_EMP_All,Employees.class)
				.getResultList();
	}
	
}