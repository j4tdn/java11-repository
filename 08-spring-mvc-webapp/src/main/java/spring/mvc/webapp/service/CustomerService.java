package spring.mvc.webapp.service;

import java.util.List;

import common.Pageable;
import spring.mvc.webapp.entity.Customer;

public interface CustomerService {
	List<Customer> findAll();
	
	List<Customer> findAll(Pageable pageable);
	
	int countTotalItems();
	
	void save(Customer customer);
	
	Customer get(int id);

	void delete(int id);

	
}
