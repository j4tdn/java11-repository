package service;

import java.util.List;
import dao.EmployeeDao;
import dao.HibernateEmployeeDao;
import persistence.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;
	
	public EmployeeServiceImpl() {
		employeeDao = new HibernateEmployeeDao();
	}

	public List<Employee> getEmpByDeptId(String dptId) {
		return employeeDao.getEmpByDeptId(dptId);
	}

	@Override
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}
}