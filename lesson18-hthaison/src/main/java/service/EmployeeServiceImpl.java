package service;

import java.util.List;

import dao.HibernateEmpDao;
import persistence.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	HibernateEmpDao hib;

	public EmployeeServiceImpl() {
		 hib = new HibernateEmpDao();
	}
	public List<Employee> getEmployeeByDept_ID(String deptId) {	
		return hib.getEmployeeByDept_ID(deptId);
	}

	public List<Employee> getAll() {
		return hib.getAll();
	}

}
