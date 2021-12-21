package provider;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import persistence.ItemGroup;

import java.util.Properties;

public class HibernateProvider {

    private static SessionFactory sessionFactory;

    private static final String HIBERNATE_PROPERTIES_PATH ="hibernate.cfg.xml";

    public static void main(String[] args) {
        System.out.println(getSessionFactory());
    }

    private HibernateProvider() {

    }

    /**
     *
     * XML configure
     */
    public static SessionFactory getSessionFactory() {
        if(sessionFactory==null){
            Configuration configuration = new Configuration();

            sessionFactory = configuration.configure(HIBERNATE_PROPERTIES_PATH).buildSessionFactory();
        }
        return sessionFactory;
    }



    /**
     * Java configure
     */
//    public static SessionFactory getSessionFactory() {
//        if(sessionFactory==null){
//            Properties properties = getHibernateProps();
//            Configuration configuration = new Configuration();
//            configuration.addAnnotatedClass(ItemGroup.class);
//           sessionFactory = configuration.setProperties(properties).buildSessionFactory();
//        }
//        return sessionFactory;
//    }

    /**
     *
     * Set properties
     */

    public static Properties getHibernateProps()
    {
        Properties props = new Properties();

        props.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL,"jdbc:mysql://localhost:3306/java11_shopping");
        props.put(Environment.USER,"root");
        props.put(Environment.PASS,"123456789");
        props.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
        props.put(Environment.SHOW_SQL,"true");
        props.put(Environment.FORMAT_SQL,"true");
        props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");

        return props;
    }


}
