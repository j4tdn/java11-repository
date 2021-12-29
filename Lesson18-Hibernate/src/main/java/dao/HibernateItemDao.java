package dao;

import org.hibernate.Session;
import persistence.Item;

import java.util.List;

public class HibernateItemDao extends AbstactHibernateDao implements ItemDao {
    private Session session;

    public HibernateItemDao() {
    }

    private static final String Q_GET_ALL = "select * from mathang";
    private static final String Q_GET_ITEM = "select * from mathang where mamh=:id";

    @Override
    public List<Item> getAll() {
        Session session = openSession();
       return session.createNativeQuery(Q_GET_ALL, Item.class).getResultList();
    }

    @Override
    public Item getItem(Integer id) {
        Session session = openSession();
        //return session.createNativeQuery(Q_GET_ITEM, Item.class).setParameter("id", id, IntegerType.INSTANCE).getSingleResult();
        //return session.createNativeQuery(Q_GET_ITEM,Item.class).setParameter("id",id,IntegerType.INSTANCE).uniqueResult();
        //Optional<Item> item = session.createNativeQuery(Q_GET_ITEM, Item.class).setParameter("id", id, IntegerType.INSTANCE).uniqueResultOptional();
        //        if (item.isPresent())
        //            return item.get();
        Item item1 = session.get(Item.class,id);

        Item item2 = session.get(Item.class,3);

        System.out.println("**********************");
        System.out.println(item1);
        System.out.println(item2);
        session.clear();
        return null;

    }
}
