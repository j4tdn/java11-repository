package com.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entity.Customer;

@Repository
public class HibernateCustomerDao implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	private final String Q_GET_ALL_CUSTOMERS = "SELECT * FROM Customer";
	
	
	@Override
	public List<Customer> getAll() {
		
		return sessionFactory.getCurrentSession().createNativeQuery(Q_GET_ALL_CUSTOMERS, Customer.class)
				.getResultList();
	}
	
}
