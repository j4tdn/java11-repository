package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import provider.HibernateProvider;

public class AbstractHibernateDao {

	private SessionFactory factory;

	AbstractHibernateDao() {
		factory = HibernateProvider.getSessionFactory();
	}

	// opt 1:	Using openSession >> thread
	// 			always create new thread, new session
	Session openSession() {
		return factory.openSession();
	}
	
	// opt 2: Using getCurrentSession >> thread
	// 			only create One unique thread, session for each session factory
	// 			requart transion
	Session getCurrentSession() {
		return factory.getCurrentSession();
	}
}
