package com.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.CustomerDao;
import com.spring.entity.Customer;

@Service
public class CustomerServiceImpl  implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<Customer> getALL() {
		return customerDao.getAll();
	}

}
