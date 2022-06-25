package spring.mvc.dao;

import java.util.List;

import spring.mvc.entity.Customer;

public interface CustomerDao {

	List<Customer> getAll();
	
	void save(Customer customer);
}
