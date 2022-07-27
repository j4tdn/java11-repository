package spring.mvc.webapp.service;

import java.util.List;

import spring.mvc.webapp.entity.Customer;

public interface CustomerService {
	List<Customer> findAll();
	
	void save(Customer customer);
	
	Customer get(int id);

	void delete(int id);
}
