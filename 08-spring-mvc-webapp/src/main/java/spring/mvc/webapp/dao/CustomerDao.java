package spring.mvc.webapp.dao;

import java.util.List;

import common.Pageable;
import spring.mvc.webapp.entity.Customer;

public interface CustomerDao {
	List<Customer> findAll();

	List<Customer> findAll(Pageable pageable);
	
	int countTotalItems();

	void saveOrUpdate(Customer customer);

	Customer get(int id);

	void delete(int id);

}
