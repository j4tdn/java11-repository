package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import provider.HibernateProvider;

public class AbstractHibernateDao {
	
	private SessionFactory factory;
	
	AbstractHibernateDao() {
		factory = HibernateProvider.getSessionFactory();
	}

	// Option 1: Using openSession >> thread
	//           Always create new thread, new session while calling openSession
	Session openSession() {
		return factory.openSession();
	}
	
	// Option 2: Using getCurrentSession >> thread
	//           Only create ONE unique thread, session for each Session Factory
	//           Required a Transaction
	Session getCurrentSession() {
		return factory.getCurrentSession();
	}
	
}
