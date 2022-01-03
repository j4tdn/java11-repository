package dao;

import java.util.List;
import org.hibernate.type.StringType;
import persistence.Employee;

public class HibernateEmployeeDao extends AbstractHibernateDao implements EmployeeDao {

	private final String G_ALL_EMP_BY_DPT_ID = "SElECT * \n" + "FROM employee\n" + "WHERE dept_id = :dptId";

	private final String G_ALL_EMP = "SElECT * \n" + "FROM employee\n" + "ORDER BY dept_id";

	public List<Employee> getEmpByDeptId(String dptId) {
		return openSession().createNativeQuery(G_ALL_EMP_BY_DPT_ID, Employee.class)
				.setParameter("dptId", dptId, StringType.INSTANCE).getResultList();
	}

	public List<Employee> getAll() {
		return openSession().createNativeQuery(G_ALL_EMP, Employee.class).getResultList();
	}
}