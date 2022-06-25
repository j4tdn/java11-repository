package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.CustomerDao;
import com.spring.entity.Customer;
import com.spring.sorting.SortOrder;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	@Transactional
	public List<Customer> getAll() {
		return customerDao.getAll();
	}
	
	@Override
	@Transactional
	public List<Customer> getAll(SortOrder sortOrder) {
		return customerDao.getAll(sortOrder);
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		customerDao.save(customer);
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

	@Override
	@Transactional
	public List<Customer> search(String param) {
		return customerDao.search(param);
	}
	
}
