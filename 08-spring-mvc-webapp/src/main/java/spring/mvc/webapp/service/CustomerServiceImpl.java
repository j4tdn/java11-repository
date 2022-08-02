package spring.mvc.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.Pageable;
import spring.mvc.webapp.dao.CustomerDao;
import spring.mvc.webapp.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<Customer> findAll() {
		return customerDao.findAll();
	}
	
	@Override
	@Transactional
	public List<Customer> findAll(Pageable pageable) {
		return customerDao.findAll(pageable);
	}
	
	@Override
	@Transactional
	public int countTotalItems() {
		return customerDao.countTotalItems();
	}
	
	@Override
	@Transactional
	public void save(Customer customer) {
		customerDao.saveOrUpdate(customer);
	}
	
	@Override
	@Transactional
	public Customer get(int id) {
		return customerDao.get(id);
	}
	
	@Override
	@Transactional
	public void delete(int id) {
		customerDao.delete(id);
	}
}
