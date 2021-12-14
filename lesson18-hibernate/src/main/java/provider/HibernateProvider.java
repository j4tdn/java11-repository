package provider;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import persistence.Item;
import persistence.ItemGroup;

public class HibernateProvider {
	private static SessionFactory sessionFactory;

	private HibernateProvider() {

	}

	/**
	 * 
	 * XML Configuration
	 */
	/*
	 * public static SessionFactory getSessionFactory() { if (sessionFactory ==
	 * null) { Configuration configuration = new Configuration(); sessionFactory =
	 * configuration.configure("hibernate.cfg.xml").buildSessionFactory(); }
	 * 
	 * return sessionFactory; }
	 */

	/**
	 * JAVA Configuration
	 */

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Properties properties = getHibernateProp();

			Configuration configuration = new Configuration();
			// Scan Entities
			configuration.addAnnotatedClass(ItemGroup.class);
			configuration.addAnnotatedClass(Item.class);

			sessionFactory = configuration.setProperties(properties).buildSessionFactory();
		}
		return sessionFactory;
	}

	private static Properties getHibernateProp() {
		Properties props = new Properties();

		props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		props.put(Environment.URL, "jdbc:mysql://localhost:3306/java11_shopping");
		props.put(Environment.USER, "root");
		props.put(Environment.PASS, "1950");
		props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		props.put(Environment.SHOW_SQL, "true");
		props.put(Environment.FORMAT_SQL, "true");
		props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

		return props;

	}

}
