package service;

import java.util.List;

import dao.EmployeeDao;
import dao.HibernateEmployeeDaoImpl;
import persistence.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao employeeDao;
	
	public EmployeeServiceImpl() {
		employeeDao = new HibernateEmployeeDaoImpl();
	}
	
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}
	
	public List<Employee> getAllAndSortByDeptId() {
		return employeeDao.getAllAndSortByDeptId();
	}
}
