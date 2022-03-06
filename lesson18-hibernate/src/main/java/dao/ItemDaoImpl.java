package dao;

import java.util.List;

import org.hibernate.type.IntegerType;

import persistence.Item;

public class ItemDaoImpl extends AbstractHibernateDao implements HibernateItemDao{
	private static final String Q_GET_ALL = "SELECT * FROM MatHang";
	private static final String Q_GET_ITEM = "SELECT * FROM MatHang WHERE MaMH = :MaMH";
	
	@Override
	public List<Item> getAll() {
		return openSession().createNativeQuery(Q_GET_ALL, Item.class).getResultList();
	}
	
	// Using native query  | persistence query return entity with no cache
	public Item getItem(int itemId) {
		return openSession().createNativeQuery(Q_GET_ITEM, Item.class)
				.setParameter("MaMH", itemId, IntegerType.INSTANCE)
				.uniqueResult();
	}
	
}
