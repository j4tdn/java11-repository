package spring.mvc.webapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractHibernateDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	Session openSession() {
		return sessionFactory.openSession();
	}
	
	Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
}
