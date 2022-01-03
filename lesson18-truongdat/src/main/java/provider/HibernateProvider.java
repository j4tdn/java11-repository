package provider;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateProvider {
	private static SessionFactory sessionFactory;
	private static String HIBERNATE_PROPERTIES_PATH = "hibernate.cfg.xml";

	private HibernateProvider() {
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			sessionFactory = configuration.configure(HIBERNATE_PROPERTIES_PATH).buildSessionFactory();
		}
		return sessionFactory;
	}
}
