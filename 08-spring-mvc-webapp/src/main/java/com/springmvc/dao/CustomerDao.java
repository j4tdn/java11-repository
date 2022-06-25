package com.springmvc.dao;

import java.util.List;

import com.springmvc.entity.Customer;

public interface CustomerDao {
	List<Customer> getAll();
	
	void save(Customer customer);

	Customer get(int id);

	void delete(int id);
}