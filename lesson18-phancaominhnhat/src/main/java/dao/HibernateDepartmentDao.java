package dao;

import java.util.List;

import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.StringType;

import persistence.DepartmentDto;

public class HibernateDepartmentDao extends AbstractHibernateDao implements DepartmentDao {
	
	private final String GET_TOTAL_BUDGET_DEPT = 
			"SELECT department.dept_name " + DepartmentDto.DEPT_NAME + ",\n"
			+ "CONCAT(GROUP_CONCAT(project.pro_name, \"-\", project.budget)) " + DepartmentDto.PROJECT_DETAILS + " ,\n"
			+ "SUM(project.budget) " + DepartmentDto.BUDGE + " \n"
			+ "FROM department\n"
			+ "LEFT JOIN project\n"
			+ "ON department.dept_id = project.dept_id\n"
			+ "LEFT JOIN project_employee\n"
			+ "ON project.pro_id = project_employee.pro_id\n"
			+ "WHERE YEAR(project_employee.start_date) = :year\n"
			+ "GROUP BY department.dept_id;";
	
	private final String GET_DEPT_PROJECT_HIGHEST = 
			"SELECT department.dept_name " + DepartmentDto.DEPT_NAME + ",\n"
			+ "		project.pro_name " + DepartmentDto.PROJECT_DETAILS+ "   ,\n"
			+ "     project.budget " + DepartmentDto.BUDGE + "     \n"
			+ "FROM department\n"
			+ "LEFT JOIN project\n"
			+ "ON department.dept_id = project.dept_id\n"
			+ "LEFT JOIN project_employee\n"
			+ "ON project.pro_id = project_employee.pro_id\n"
			+ "WHERE YEAR(project_employee.start_date) = :year\n"
			+ "ORDER BY project.budget DESC\n"
			+ "LIMIT 1;";
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<DepartmentDto> getTotalBudgetOfDept(int year) {
		return openSession().createNativeQuery(GET_TOTAL_BUDGET_DEPT)
				.setParameter("year", year)
				.addScalar(DepartmentDto.DEPT_NAME, StringType.INSTANCE)
				.addScalar(DepartmentDto.PROJECT_DETAILS, StringType.INSTANCE)
				.addScalar(DepartmentDto.BUDGE, DoubleType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(DepartmentDto.class))
				.getResultList();
	}

	@SuppressWarnings("deprecation")
	public DepartmentDto getDepartmentBudgetHighInYear(int year) {
		return (DepartmentDto) openSession().createNativeQuery(GET_DEPT_PROJECT_HIGHEST)
				.setParameter("year", year)
				.addScalar(DepartmentDto.DEPT_NAME, StringType.INSTANCE)
				.addScalar(DepartmentDto.PROJECT_DETAILS, StringType.INSTANCE)
				.addScalar(DepartmentDto.BUDGE, DoubleType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(DepartmentDto.class))
				.getSingleResult();
	}
	
}
