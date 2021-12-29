package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import provider.HibernateProvider;

public class AbstactHibernateDao {

    private final SessionFactory sessionFactory;

    AbstactHibernateDao() {
        sessionFactory = HibernateProvider.getSessionFactory();
    }

    Session openSession() {
        return sessionFactory.openSession();
    }

    Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
