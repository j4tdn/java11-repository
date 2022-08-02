package spring.mvc.webapp.service;

import java.util.List;

import common.Pageable;
import spring.mvc.webapp.entity.Customer;

public interface CustomerService {
	List<Customer> findAll();
	
	List<Customer> findAll(Pageable pageable, String sortField, String sortDir);
	
	int countTotalItems();
	
	void save(Customer customer);
	
	Customer get(int id);

	void delete(int id);

	
}
