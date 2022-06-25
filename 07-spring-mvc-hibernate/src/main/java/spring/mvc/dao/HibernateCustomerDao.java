package spring.mvc.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateCustomerDao implements CustomerDao{

	private SessionFactory sessionFactory;
	
	@Override
	public void testConnection() {
		System.out.println("Connection: " + sessionFactory.openSession());
	}

}
