package spring.mvc.webapp.dao;

import java.util.List;

import spring.mvc.webapp.entity.Customer;

public interface CustomerDao {
	List<Customer> findAll();
	
	void saveOrUpdate(Customer customer);
	
	Customer get(int id);

	void delete(int id);
}
