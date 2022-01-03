package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import persistence.EmployeeDto;
import persistence.Employee;

public class HibernateEmployeeDao extends AbstractHibernateDao  implements EmployeeDao{

	private static final String Q_GET_ALL = "SELECT * FROM employee";
	private static final String Q_GET = "SELECT * FROM employee WHERE dept_id = :id";
	
	private final String Q_GET_EMPLOYEES_EACH_DEPARTMENT_ASC =
            "select d.dept_id as " + EmployeeDto.DEPARTMENT_ID + " , d.dept_name as " + EmployeeDto.DEPARTMENT_NAME +
                    ", e.emp_id as " + EmployeeDto.EMPLOYEE_ID + ",e.emp_name as " + EmployeeDto.EMPLOYEE_NAME + ",e.age as " + EmployeeDto.EMPLOYEE_AGE +
                    ", e.salary as " + EmployeeDto.EMPLOYEE_SALARY +
                    " from department as d  inner join employee as e on " +
                    "e.dept_id=d.dept_id order by d.dept_id asc";
	
	public List<Employee> getAll() {
		Session session = openSession();

		return session.createNativeQuery(Q_GET_ALL, Employee.class).getResultList();
	}
	
	public List<Employee> get(String dept_id) {
		return (List<Employee>) openSession().createNativeQuery(Q_GET, Employee.class)
							.setParameter("id", dept_id, StringType.INSTANCE)
							.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<EmployeeDto> getEmployeeOrderByDepId(){
		return (List<EmployeeDto>) openSession().createNativeQuery(Q_GET_EMPLOYEES_EACH_DEPARTMENT_ASC)
									.addScalar(EmployeeDto.DEPARTMENT_ID, StringType.INSTANCE)
									.addScalar(EmployeeDto.DEPARTMENT_NAME,StringType.INSTANCE)
									.addScalar(EmployeeDto.EMPLOYEE_ID,StringType.INSTANCE)
									.addScalar(EmployeeDto.EMPLOYEE_NAME,StringType.INSTANCE)
									.addScalar(EmployeeDto.EMPLOYEE_AGE,IntegerType.INSTANCE)
									.addScalar(EmployeeDto.EMPLOYEE_SALARY,DoubleType.INSTANCE)
									.setResultTransformer(Transformers.aliasToBean(EmployeeDto.class))
									.getResultList();
	}

   
}
