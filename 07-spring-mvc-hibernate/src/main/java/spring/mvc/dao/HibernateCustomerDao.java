package spring.mvc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateCustomerDao implements CustomerDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void testConnection() {
		System.out.println("Connection: " + sessionFactory.openSession());
	}

}
