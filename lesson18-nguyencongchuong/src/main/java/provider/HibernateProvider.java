package provider;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import persistence.Department;
import persistence.Employee;
import persistence.Project;

public class HibernateProvider {

	private static final String HIBERNATE_PROPERTIES_PATH = "hibernate.cfg.xml";
	private static SessionFactory sessionFactory;
	
	private HibernateProvider() {
	}
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			
			configuration.addAnnotatedClass(Employee.class);
			configuration.addAnnotatedClass(Department.class);
			configuration.addAnnotatedClass(Project.class);
			
			
			sessionFactory = configuration.setProperties(getHibernateProps())
										  .buildSessionFactory();
		}
		return sessionFactory;
	}
	
	private static Properties getHibernateProps() {
		Properties props = new Properties();
		
		props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		props.put(Environment.URL, "jdbc:mysql://localhost:3306/hib_comman_cache");
		props.put(Environment.USER, "root");
		props.put(Environment.PASS, "1234");
		
		props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		props.put(Environment.SHOW_SQL, "false");
		props.put(Environment.FORMAT_SQL, "true");
		props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
		
		// Second Level Cache
//		props.put(Environment.USE_SECOND_LEVEL_CACHE, "true");
//		props.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
//		props.put(Environment.CACHE_PROVIDER_CONFIG, "ehcache.xml");
		
		return props;
	}
	
}
