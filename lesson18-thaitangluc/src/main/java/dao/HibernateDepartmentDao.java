package dao;

import java.util.List;

import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import persistence.DepartmentDto;

public class HibernateDepartmentDao extends AbstractHibernateDao implements DepartmentDao {
	private static final String Q_GET_DEPT_TOTAL_BUDGET = 
			  "SELECT dept.dept_name " + DepartmentDto.DEPT_NAME + ",\n"
			+ "		  GROUP_CONCAT(concat(pro.pro_name, ' ', pro.budget) SEPARATOR ', ') "
			+ 				DepartmentDto.PRO_DETAIL + ",\n"
			+ "		  SUM(pro.budget) "+ DepartmentDto.DEPT_TOTAL + " \n"
			+ "FROM project pro\n"
			+ "JOIN department dept\n"
			+ " ON pro.dept_id = dept.dept_id\n"
			+ "JOIN project_employee proEmpl \n"
			+ " ON pro.pro_id = proEmpl.pro_id\n"
			+ "WHERE CAST(proEmpl.start_date AS YEAR) = :year\n"
			+ "GROUP BY dept.dept_id";
	
	private static final String Q_GET_DEPT_HIGHEST_BUDGET =
			"SELECT dept.dept_name " + DepartmentDto.DEPT_NAME +",\n"
			+ "	   pro.pro_name " + DepartmentDto.PRO_DETAIL + ",\n"
			+ "       pro.budget " + DepartmentDto.DEPT_TOTAL + "\n"
			+ "FROM project pro \n"
			+ "JOIN department dept \n"
			+ " ON pro.dept_id = dept.dept_id \n"
			+ "JOIN project_employee proEmpl \n"
			+ " ON pro.pro_id = proEmpl.pro_id \n"
			+ "WHERE CAST(proEmpl.start_date AS YEAR) = :year \n"
			+ "ORDER BY pro.budget DESC \n"
			+ "LIMIT 1";
	
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<DepartmentDto> getDeptTotalBudget(int year) {
		return openSession().createNativeQuery(Q_GET_DEPT_TOTAL_BUDGET)
				.setParameter("year", year, IntegerType.INSTANCE)
				.addScalar(DepartmentDto.DEPT_NAME, StringType.INSTANCE)
				.addScalar(DepartmentDto.PRO_DETAIL, StringType.INSTANCE)
				.addScalar(DepartmentDto.DEPT_TOTAL, DoubleType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(DepartmentDto.class))
				.getResultList();
	}
	
	@SuppressWarnings("deprecation")
	public DepartmentDto getDeptHighestBudget(int year) {
		return (DepartmentDto) openSession().createNativeQuery(Q_GET_DEPT_HIGHEST_BUDGET)
				.setParameter("year", year, IntegerType.INSTANCE)
				.addScalar(DepartmentDto.DEPT_NAME, StringType.INSTANCE)
				.addScalar(DepartmentDto.PRO_DETAIL, StringType.INSTANCE)
				.addScalar(DepartmentDto.DEPT_TOTAL, DoubleType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(DepartmentDto.class))
				.getSingleResult();
	}

}