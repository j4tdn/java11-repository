package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import provider.HibernateProvider;

public class AbstractHibernateDao {

    private final SessionFactory sessionFactory;

    public AbstractHibernateDao()
    {
        sessionFactory= HibernateProvider.getSessionFactory();
    }
    Session OpenSession()
    {
        return sessionFactory.openSession();
    }
    Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

}
