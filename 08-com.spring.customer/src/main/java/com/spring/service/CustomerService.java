package com.spring.service;

import java.util.List;

import com.spring.entity.Customer;
import com.spring.sorting.SortOrder;

public interface CustomerService {
	List<Customer> getAll();
	List<Customer> getAll(SortOrder sortOrder);
	void save(Customer customer);
	Customer get(int customerId);
	void delete(int id);
	List<Customer> search(String param);
	
}
