package dao;

import java.util.List;

import persistence.Item;

public class ItemDaoImpl extends AbstractHibernateDao implements HibernateItemDao{
	private static final String Q_GET_ALL = "SELECT * FROM MatHang";
	
	@Override
	public List<Item> getAll() {
		return openSession().createNativeQuery(Q_GET_ALL, Item.class).getResultList();
	}
	
}
