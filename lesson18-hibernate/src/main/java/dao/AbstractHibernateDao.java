package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import provider.HibernateProvider;

public class AbstractHibernateDao {
	
	private  SessionFactory factory;
	public AbstractHibernateDao() {
		factory = HibernateProvider.getSessionFactory();
	}
	
	//Option 1: Using openSession
	//			Alway create new thread, new session while calling openSession
	//			Not require transacsion
	Session openSession() {
		return factory.openSession();
	}
	
	//Option 2: Using getCurrentSession >> sync thread
	//			Only create ONE unique thread, session for each Session Factory
	//			Require a transaction (*)
	Session getCurrentSession() {
		return factory.getCurrentSession();
	}
	
}
