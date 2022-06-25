package spring.mvc.service;

import java.util.List;

import spring.mvc.entity.Customer;

public interface CustomerService {
	List<Customer> getAll();
	
	void save(Customer customer);
}
