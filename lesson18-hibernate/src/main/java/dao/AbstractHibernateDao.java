package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import provider.HibernateProvider;

public class AbstractHibernateDao {
 
	private static SessionFactory factory;
	
	public AbstractHibernateDao(){
		factory = HibernateProvider.getSessionFactory();
	}
	
	// Option 1: Using openSession >> thread
	//           always create new thread, new session while calling
	Session openSession() {
		return  factory.openSession();
	}
	
	// Option 2: Using getCurrentSession >> thread
	// Only create ONE unique thread, session for each Session Factory
	
	Session getCurrenSession() {
		return factory.getCurrentSession();
	}
}
