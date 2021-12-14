package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import persistence.ItemGroup;

import java.util.List;

public class HibernateItemGroupDAO extends AbstractHibernateDAO implements ItemGroupDao {

    // private String Q_GET_ALL = "SELECT * FROM LoaiHang"; // Native SQL
    // private String Q_GET_ALL = "SELECT ig FROM ItemGroup ig"; // JPQL, HQL

    @Override
    public List<ItemGroup> getAll() {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        // NativeQuery<ItemGroup> query = null;
        Query<ItemGroup> query = null;
        try {
            // Unknown entity: persistence.ItemGroup
            // query = session.createNativeQuery(Q_GET_ALL, ItemGroup.class);
            // query = session.createQuery(Q_GET_ALL, ItemGroup.class);

            query = session.createNamedQuery(ItemGroup.Q_GET_ALL, ItemGroup.class);

            // transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

        return query.getResultList();
    }
}
