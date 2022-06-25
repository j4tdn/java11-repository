package com.spring.dao;

import java.util.List;

import com.spring.entity.Customer;
import com.spring.sorting.SortOrder;

public interface CustomerDao {
	List<Customer> getAll();

	Customer get(int id);

	void save(Customer customer);

	void delete(int id);

	List<Customer> search(String param);

	List<Customer> getAll(SortOrder sortOrder);
}
