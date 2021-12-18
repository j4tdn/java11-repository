package dao;

import java.util.List;

import persistence.Item;

public class HibernateItemDao extends AbstractHibernateDao implements ItemDao {

	private static final String Q_GET_ALL = "SELECT * FROM MatHang";
	
	public List<Item> getAll() {
		return openSession().createNativeQuery(Q_GET_ALL, Item.class).getResultList();
	}
	
}
