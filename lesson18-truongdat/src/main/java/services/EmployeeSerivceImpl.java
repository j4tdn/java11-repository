package services;

import java.util.List;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import persistences.Employee;

public class EmployeeSerivceImpl implements EmployeeService{
	private EmployeeDao employeeDao;
	
	public EmployeeSerivceImpl() {
		employeeDao = new EmployeeDaoImpl();
	}
	public List<Employee> getByDeptId(String deptId) {
		return employeeDao.getByDeptId(deptId);
	}
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}
}
