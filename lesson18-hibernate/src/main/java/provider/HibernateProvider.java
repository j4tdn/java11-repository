package provider;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import persistence.Item;
import persistence.ItemGroup;

public class HibernateProvider {
	
	private static SessionFactory sessionFactory;
	private static String HIBARNATE_PROERTIES_PATH = "hibernate.cfg.xml";
	
	private HibernateProvider() {
		
	}
	
	/*
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			Configuration configuration = new Configuration();
			sessionFactory = configuration.configure(HIBARNATE_PROERTIES_PATH).buildSessionFactory();
		}
		
		return sessionFactory;
	}
	*/
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			Configuration configuration = new Configuration();
			
			configuration.addAnnotatedClass(ItemGroup.class);
			configuration.addAnnotatedClass(Item.class);
			
			sessionFactory = configuration.setProperties(getHivernateProps()).buildSessionFactory();
		}
		
		return sessionFactory;
	}
	
	private static Properties getHivernateProps() {
		Properties props = new Properties();

		props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		props.put(Environment.URL, "jdbc:mysql://localhost:3306/java11_shopping");
		props.put(Environment.USER, "root");
		props.put(Environment.PASS, "1234");
		
		props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		props.put(Environment.SHOW_SQL, "true");
		props.put(Environment.FORMAT_SQL, "true");
		props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
		
		
		return props;
	}
}