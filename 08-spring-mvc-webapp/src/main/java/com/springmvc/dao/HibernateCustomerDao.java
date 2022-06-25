package com.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.entity.Customer;

@Repository
public class HibernateCustomerDao implements CustomerDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT * FROM customer ", Customer.class)
				      .getResultList();
	}
	
	
	@Override
	public void save(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}
	
	
	@Override
	public Customer get(int id) {
		Session session = sessionFactory.getCurrentSession();
		return  session.get(Customer.class, id);
	}
	
	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.createNativeQuery("DELETE FROM customer WHERE id=:id")
			   .setParameter("id", id)
			   .executeUpdate();
	}
}