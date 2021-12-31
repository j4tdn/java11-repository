package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import provider.HibernateProvider;

public class AbstractHibernateDao {
    private SessionFactory factory;

    AbstractHibernateDao(){
        factory = HibernateProvider.getSessionFactory();
    }

    Session openSession(){
        return factory.openSession();
    }

    Session getCurrentSession(){
        return factory.getCurrentSession();
    }

}
