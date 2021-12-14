package dao;

import persistence.Item;

import java.util.List;

public class HibernateItemDao extends AbstractHibernateDAO implements ItemDao {

    private static final String Q_GET_ALL = "SELECT * FROM MatHang";

    @Override
    public List<Item> getAll() {
        return openSession().createNativeQuery(Q_GET_ALL, persistence.Item.class).getResultList();
    }
}
