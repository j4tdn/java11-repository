package dao;

import java.util.List;

import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.StringType;

import persistences.DepartmentDto;

public class DepartmentDaoImpl extends AbstractHibernateDao implements DepartmentDao{
	private static String Q_GET_LIST_TOTAL_BUDGET_IN_YEAR = 
			"SELECT d.dept_name " + DepartmentDto.DEPT_NAME + ", "
					+ "p.pro_name " +  DepartmentDto.PRO_NAME
					+ ", SUM(p.budget) "+ DepartmentDto.DEPT_TOTAL +"\n"
			+ "FROM Project p \n"
			+ "JOIN department d\n"
			+ "ON p.dept_id = d.dept_id \n"
			+ "JOIN project_employee pe\n"
			+ "ON p.pro_id = pe.pro_id\n"
			+ "WHERE YEAR(pe.start_date) = :year\n"
			+ "GROUP BY d.dept_id";
	
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<DepartmentDto> getListTotalBudgetPerDepartmentIn(int year) {
		return openSession().createNativeQuery(Q_GET_LIST_TOTAL_BUDGET_IN_YEAR)
				.setParameter("year", year)
				.addScalar(DepartmentDto.DEPT_NAME, StringType.INSTANCE)
				.addScalar(DepartmentDto.PRO_NAME, StringType.INSTANCE)
				.addScalar(DepartmentDto.DEPT_TOTAL, DoubleType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(DepartmentDto.class))
				.getResultList();
	}

}
