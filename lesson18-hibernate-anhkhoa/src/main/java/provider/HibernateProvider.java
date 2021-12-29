package provider;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import persistence.Department;
import persistence.Employee;
import persistence.Project;
import persistence.Project_Employee;

import java.util.Properties;

public class HibernateProvider {
    private static SessionFactory sessionFactory;

    private static final String HIBERNATE_PROPERTIES_PATH = "hibernate.cfg.xml";

    /**
     *
     * configure by file xml
     */
//    public static SessionFactory getSessionFactory()
//    {
//        Configuration configuration = new Configuration();
//        if(sessionFactory==null)
//        {
//            sessionFactory = configuration.configure(HIBERNATE_PROPERTIES_PATH).buildSessionFactory();
//        }
//        return sessionFactory;
//    }

    /**
     *
     * configure by java
     */

    public static SessionFactory getSessionFactory()
    {
        Properties props = getProperties();
        if(sessionFactory==null)
        {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Employee.class);
            configuration.addAnnotatedClass(Department.class);
            configuration.addAnnotatedClass(Project.class);
            configuration.addAnnotatedClass(Project_Employee.class);
            sessionFactory = configuration.setProperties(props).buildSessionFactory();
        }

        return sessionFactory;
    }

    /**
     * set properties
     */
    public static Properties getProperties()
    {
        Properties props = new Properties();

        props.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL,"jdbc:mysql://localhost:3306/hib_comman_cache");
        props.put(Environment.USER,"root");
        props.put(Environment.PASS,"123456789");
        props.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
        props.put(Environment.SHOW_SQL,"true");
        props.put(Environment.FORMAT_SQL,"true");
        props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
        props.put(Environment.USE_SECOND_LEVEL_CACHE,"true");
        props.put(Environment.CACHE_REGION_FACTORY,"org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
        props.put(Environment.CACHE_PROVIDER_CONFIG,"ehcache.xml");

        return props;
    }
}
