package service;

import java.util.List;

import dao.EmployeeDao;
import dao.HibernateEmployeeDao;
import persistence.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao employeeDao;
	
	public EmployeeServiceImpl() {
		employeeDao = new HibernateEmployeeDao();
	}
	
	public List<Employee> getByDeptId(String deptId) {
		return employeeDao.getByDeptId(deptId);
	}
}
