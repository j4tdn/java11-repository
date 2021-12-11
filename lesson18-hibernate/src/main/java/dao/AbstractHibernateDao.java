package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import provider.HibernateProvider;

public class AbstractHibernateDao {
	public SessionFactory factory;

	AbstractHibernateDao() {
		factory = HibernateProvider.getSessionFactory();
	}
	
	// Option 1: Using openSession >> thread
	// 		    Always create new thread , new session while calling openSession
	Session openSession() {
		return factory.openSession();
	}
	
	// Option 2: 
	Session getCurrentSession() {
		return factory.getCurrentSession();
	}
}
