package dao;

import java.util.List;

import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import persistence.DepartmentDto;

public class HibernateDepartmentImpl extends AbstractHibernateDao implements DepartmentDao{
	private String Q_GET_TOTAL_OF_BUDGET_IN_YEAR = "SELECT de.dept_name " + DepartmentDto.DEPT_ID + " , \n"
			+ "	   concat(GROUP_CONCAT(pro.pro_name)) "+ DepartmentDto.DEPT_NAME +", \n"
			+ "       SUM(pro.budget) " + DepartmentDto.DEPT_TOTAL+ " \n"
			+ "FROM project_employee pe\n"
			+ "JOIN project pro ON pro.pro_id = pe.pro_id\n"
			+ "JOIN department de ON de.dept_id = pro.dept_id\n"
			+ "WHERE year(start_date) = :year\n"
			+ "GROUP BY de.dept_id";
	
	
	private String Q_GET_DEPARTMENT_HAS_PROJECT_HIGHEST_BUDGET = "SELECT dept.dept_name " + DepartmentDto.DEPT_ID+ " , \n"
			+ "	   pro.pro_name " + DepartmentDto.DEPT_NAME + " ,\n"
			+ "       pro.budget " + DepartmentDto.DEPT_TOTAL + "\n"
			+ "FROM department dept\n"
			+ "JOIN project pro ON dept.dept_id = pro.dept_id\n"
			+ "JOIN project_employee pe ON pe.pro_id = pro.pro_id\n"
			+ "WHERE year(pe.start_date) = :year\n"
			+ "ORDER BY pro.budget DESC\n"
			+ "LIMIT 1;";
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<DepartmentDto> getTotalOfDepartmentInYear(int year) {
		return openSession().createNativeQuery(Q_GET_TOTAL_OF_BUDGET_IN_YEAR).setParameter("year", year)
				.addScalar(DepartmentDto.DEPT_ID, StringType.INSTANCE)
				.addScalar(DepartmentDto.DEPT_NAME, StringType.INSTANCE)
				.addScalar(DepartmentDto.DEPT_TOTAL, IntegerType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(DepartmentDto.class))
				.getResultList();
	}
	
	@SuppressWarnings("deprecation")
	public DepartmentDto getDepartmentHighestBudgetInYear(int year) {
		return (DepartmentDto) openSession().createNativeQuery(Q_GET_DEPARTMENT_HAS_PROJECT_HIGHEST_BUDGET).setParameter("year", year)
				.addScalar(DepartmentDto.DEPT_ID, StringType.INSTANCE)
				.addScalar(DepartmentDto.DEPT_NAME, StringType.INSTANCE)
				.addScalar(DepartmentDto.DEPT_TOTAL, IntegerType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(DepartmentDto.class))
				.getSingleResult();
	}
}
