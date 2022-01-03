package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateProvider {
	private static SessionFactory sessionFactory;
	private static String HIBERNATE_PROPERTIES = "hibernate.cfg.xml";
	
	private HibernateProvider() {
		
	}
	
	public static SessionFactory getSessionFactory() {
		
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			sessionFactory = configuration.configure(HIBERNATE_PROPERTIES).buildSessionFactory();
			
		}
		
		return sessionFactory;
		
	}
}
