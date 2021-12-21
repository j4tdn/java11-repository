package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import persistence.ItemGroup;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;

public class HibernateItemGroupDao extends AbstactHibernateDao implements ItemGroupDao {

    @Override
    public List<ItemGroup> getAll() {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        Query<ItemGroup> query = null;
        try {
            //query = session.createNativeQuery(Q_GET_ALL, ItemGroup.class);
            query = session.createNamedQuery(ItemGroup.Q_GET_ALL,ItemGroup.class);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return query.getResultList();
    }


}
