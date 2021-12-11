package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import provider.HibernateProvider;

public class AbstractHibernateDao {
	private SessionFactory factory;
	
	public AbstractHibernateDao() {
		factory = HibernateProvider.getSessionFactory();
	}
	
	// Option 1: Using openSession >> thread
	// Always create new thread, new session
	Session openSession() {
		return factory.openSession();
	}
	
	// Option2: Using getCurrentSession >> thread
	//			Only create ONE unique session
	Session getCurrentSession() {
		return factory.getCurrentSession();
	}
}
