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

	public List<Employee> getEmployee(String deptId) {
		return employeeDao.getEmployee(deptId);
	}

	public List<Employee> getEmployeeSortDeptId() {
		return employeeDao.getEmployeeSortDeptId();
	}

}
