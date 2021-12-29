package service;

import java.util.List;

import dao.HibernateEmpDao;
import dao.EmployeeDao;
import persistence.Employees;

public class EmpServiceImpl implements EmployeeService{
	
	private EmployeeDao empDao;
	
	public EmpServiceImpl() {
		empDao = new HibernateEmpDao();
	}

	public List<Employees> getEmloyeeById(String deptId) {
		return empDao.getEmloyeeById(deptId);
	}
	
	public List<Employees> getAllEmp() {
		return empDao.getAllEmp();
	}

}