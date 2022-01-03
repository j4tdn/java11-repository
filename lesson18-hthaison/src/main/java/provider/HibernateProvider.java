package provider;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import persistence.Department;
import persistence.Employee;

public class HibernateProvider {
	private static SessionFactory sessionFactory;
	private static String HIBERNATE_PROPERTIES_PATH = "hibernate.cfg.xml";
	
	private HibernateProvider() {
	}
	
	/*
	 * public static SessionFactory getSessionFactory() { if(sessionFactory == null)
	 * { Configuration configuration = new Configuration(); sessionFactory =
	 * configuration.configure(HIBERNATE_PROPERTIES_PATH).buildSessionFactory(); }
	 * return sessionFactory; }
	 */
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			
			Configuration configuration  = new Configuration();
			configuration.addAnnotatedClass(Department.class);
			configuration.addAnnotatedClass(Employee.class);
			
			sessionFactory = configuration.setProperties(getHibernateProps()).buildSessionFactory();
			
		}
		return sessionFactory;
	}
	/*
	 * property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
	 * <property
	 * name="connection.url">jdbc:mysql://localhost:3306/java11_shopping</property>
	 * <property name="connection.username">root</property> <property
	 * name="connection.password">sonk51ca1</property>
	 */


	private static Properties getHibernateProps() {
		Properties props = new Properties();
		props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		props.put(Environment.URL, "jdbc:mysql://localhost:3306/hib_comman_cache");
		props.put(Environment.USER, "root");
		props.put(Environment.PASS, "sonk51ca1");
		
		props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		props.put(Environment.SHOW_SQL,"true");
		props.put(Environment.FORMAT_SQL, "true");
		props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
	
		
		return props;

		
	}
}
