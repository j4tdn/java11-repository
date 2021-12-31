package dao;

import java.util.List;

import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.StringType;

import persistence.DepartmentDto;

public class DeparmentDaoImpl extends AbstractHibernateDao implements DepartmentDao {
	
	private static final String GET_TOTALs_DEPARTMENT = "SELECT d.dept_name "   	+ DepartmentDto.DEPT_ID    + ",\n"
				+ "	      concat(GROUP_CONCAT(p.pro_name), \"-\", p.budget) " 		+ DepartmentDto.DEPT_NAME  + ",\n"
				+ "       SUM(p.budget) "			 								+ DepartmentDto.DEPT_TOTAL + "\n"
				+ "FROM project p\n"
				+ "JOIN department d\n"
				+ "	ON p.dept_id = d.dept_id\n"
				+ "JOIN project_employee pe\n"
				+ "	ON pe.pro_id = p.pro_id\n"
				+ "WHERE YEAR(pe.start_date) = :year\n"
				+ "GROUP BY d.dept_id";

	private static final String GET_DEPARTMENT_HIGH_BUDGET = "SELECT d.dept_name "  + DepartmentDto.DEPT_ID    + ",\n"
				+ "	   p.pro_name "  												+ DepartmentDto.DEPT_NAME  + ",\n"
				+ "        p.budget "  												+ DepartmentDto.DEPT_TOTAL + "\n"
			  	+ "FROM project p\n"
			  	+ "JOIN department d\n"
			  	+ "	ON p.dept_id = d.dept_id\n"
			  	+ "JOIN project_employee pe\n"
			  	+ "	ON pe.pro_id = p.pro_id\n"
			  	+ "WHERE YEAR(pe.start_date) = :year\n"
			  	+ "ORDER BY p.budget DESC\n"
			  	+ "LIMIT 1;";
	
	@SuppressWarnings("unchecked")
	public List<DepartmentDto> totalBudgetDepartment(int year) {
		return openSession().createNativeQuery(GET_TOTALs_DEPARTMENT)
				.setParameter("year", year)
				.addScalar(DepartmentDto.DEPT_ID, StringType.INSTANCE)
				.addScalar(DepartmentDto.DEPT_NAME, StringType.INSTANCE)
				.addScalar(DepartmentDto.DEPT_TOTAL, DoubleType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(DepartmentDto.class))
				.getResultList();
	}


	public DepartmentDto getDeparmentHighestBudget(int year) {
		return (DepartmentDto) openSession().createNativeQuery(GET_DEPARTMENT_HIGH_BUDGET)
				.setParameter("year", year)
				.addScalar(DepartmentDto.DEPT_ID, StringType.INSTANCE)
				.addScalar(DepartmentDto.DEPT_NAME, StringType.INSTANCE)
				.addScalar(DepartmentDto.DEPT_TOTAL, DoubleType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(DepartmentDto.class))
				.getSingleResult();
	}

}
