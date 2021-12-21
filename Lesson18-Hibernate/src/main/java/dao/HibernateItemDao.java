package dao;

import org.hibernate.Session;
import persistence.Item;

import java.util.List;

public class HibernateItemDao extends AbstactHibernateDao implements ItemDao{
    private Session session;

    public HibernateItemDao()
    {
    }

    private static final String Q_GET_ALL ="select * from mathang";

    @Override
    public List<Item> getAll() {
        Session session = openSession();
        return session.createNativeQuery(Q_GET_ALL,Item.class).getResultList();
    }
}
