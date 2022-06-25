package com.spring.dao;

import java.util.List;

import com.spring.entity.Customer;

public interface CustomerDao {
	List<Customer> getAll();
}
