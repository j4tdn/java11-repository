package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import provider.HibernateProvider;

public class AbstractHibernateDao {

	private  SessionFactory factory;
	
	public AbstractHibernateDao() {
		factory = HibernateProvider.getSessionFactory();
	}
	
	// Option 1 : Using openSession
	Session openSession() {
		return factory.openSession();
	}
	
	// Option 2  : Using getCurrentSession >> thread
	// Create 	only 1 session 
	Session getCurrentSession() {
		return factory.getCurrentSession();
	}
	
}
