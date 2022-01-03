package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import persistence.Department;
import persistence.DepartmentBudget;
import persistence.DepartmentBudgetYear;
import persistence.Employee;
import utils.SqlUtils;

public class HibernateDepartmentDao extends AbstractHibernateDao implements DepartmentDao {
	
	private String Q_GET_ALL = "SELECT * FROM department ";
	
	private String Q_GET_BUDGET_OF_DEPT = "SELECT dept.dept_name as "+DepartmentBudget.DEPARTMENT_NAME+", "
										+ "pro.pro_name as "+DepartmentBudget.PROJECT_NAME+", "
										+ "pro.budget as "+DepartmentBudget.SUM_BUDGET + ""
										+ "	FROM department as dept\r\n"
										+ "JOIN project as pro on dept.dept_id = pro.dept_id "
										+ "WHERE budget > :sumbud";
	
	private String Q_GET_TOTAL_BUD_IN_YEAR = "  SELECT  d.dept_name as "+DepartmentBudgetYear.DEPARTMENT_NAME+" , "
										+ "	Group_concat(distinct concat(p.pro_name,' ', p.budget)) as "+DepartmentBudgetYear.PROJECT_NAME+",\r\n"
										+ "	sum(distinct(p.budget)) as "+DepartmentBudgetYear.BUDGET+"   \r\n"
										+ "	FROM project p\r\n"
										+ "	inner join department d\r\n"
										+ "	ON p.dept_id = d.dept_id\r\n"
										+ "	inner JOIN project_employee pe\r\n"
										+ "	ON pe.pro_id = p.pro_id\r\n"
										+ "	WHERE YEAR(pe.start_date) = :year\r\n"
										+ " group by d.dept_id";
	private String Q_GET_PRO_HAVE_BUD_MAX = "SELECT distinct dept.dept_name as "+DepartmentBudget.DEPARTMENT_NAME+", "
										+ "pro.pro_name as "+DepartmentBudget.PROJECT_NAME+", "
										+ "budget as "+DepartmentBudget.SUM_BUDGET+" from department as dept\r\n"
										+ "	INNER JOIN project AS pro on dept.dept_id = pro.dept_id\r\n"
										+ " INNER JOIN project_employee AS pe ON pro.pro_id = pe.pro_id\r\n"
										+ " WHERE pro.budget =  (select max(budget) from project)";
	public List<Department> getAll() {
		Session session = getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		
		NativeQuery<Department> query = null;
		
		try {
			query = session.createNativeQuery(Q_GET_ALL, Department.class);
			//transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
		return query.getResultList();
	}


	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<DepartmentBudget> getSumBudgetOfDept(int sum) {
		return  openSession().createNativeQuery(Q_GET_BUDGET_OF_DEPT)
				.setParameter("sumbud", sum)
				.addScalar(DepartmentBudget.DEPARTMENT_NAME)
				.addScalar(DepartmentBudget.PROJECT_NAME)
				.addScalar(DepartmentBudget.SUM_BUDGET)
				.setResultTransformer(Transformers.aliasToBean(DepartmentBudget.class))
				.getResultList();
	}


	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<DepartmentBudgetYear> getBudgetbyYear(int year) {
		return openSession().createNativeQuery(Q_GET_TOTAL_BUD_IN_YEAR)
							.setParameter("year", year)
							.addScalar(DepartmentBudgetYear.DEPARTMENT_NAME, StringType.INSTANCE)
							.addScalar(DepartmentBudgetYear.PROJECT_NAME, StringType.INSTANCE)
							.addScalar(DepartmentBudgetYear.BUDGET, DoubleType.INSTANCE)
							.setResultTransformer(Transformers.aliasToBean(DepartmentBudgetYear.class))
							.getResultList();
		
		
	}


	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<DepartmentBudget> getProHaveBudMax() {
		return openSession().createNativeQuery(Q_GET_PRO_HAVE_BUD_MAX)
							.addScalar(DepartmentBudget.DEPARTMENT_NAME,StringType.INSTANCE)
							.addScalar(DepartmentBudget.PROJECT_NAME, StringType.INSTANCE)
							.addScalar(DepartmentBudget.SUM_BUDGET,DoubleType.INSTANCE)
							.setResultTransformer(Transformers.aliasToBean(DepartmentBudget.class))
							.getResultList();
	}
	


}
