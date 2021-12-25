package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import provider.HibernateProvider;

public class AbstractHibernateDao {
	private SessionFactory sessionFactory;
	
	AbstractHibernateDao() {
		sessionFactory = HibernateProvider.getSessionFactory();
	}
	
	//option 1: use openSession >> thread
	//          always create new thread, new session when call openSession
	Session openSession() {
		return sessionFactory.openSession();
	}
	
	//option 2: use getCurrentSession >> thread
	//         create only one thread, session for each Session Factory
	Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
 }
