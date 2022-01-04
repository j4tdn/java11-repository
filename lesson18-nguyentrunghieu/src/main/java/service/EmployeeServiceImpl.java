package service;

import java.util.List;

import dao.EmployeeDao;
import dao.HibernateEmployeeDao;
import persistence.Employee;
import persistence.EmployeeDto;

public class EmployeeServiceImpl implements employeeService {
	private static EmployeeDao employeeDao;
	
	public EmployeeServiceImpl() {
		employeeDao= new HibernateEmployeeDao();
	}
	
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	public List<Employee> get(String dept_id) {
		return employeeDao.get(dept_id);
	}

	public List<EmployeeDto> getEmployeeOrderByDepId() {
		return employeeDao.getEmployeeOrderByDepId();
	}

}
