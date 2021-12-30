package dao;

import java.util.List;

import org.hibernate.Session;

import persistence.Item;

public class HibernateItemDao extends AbstractHibernateDao implements ItemDao{
	
	private static final String Q_GET_ALL = "SELECT * FROM MatHang";
	private static final String Q_GET_ITEM = "SELECT * FROM MatHang WHERE MaMH = :MaMH";

	public List<Item> getAll() {
		return openSession().createNativeQuery(Q_GET_ALL, Item.class).getResultList();
	}
	
	public Item getItem(int itemId) {
		Session session1 = openSession();
		Session session2 = openSession();
		
		Item item1 = session1.get(Item.class, 3);
		
		session1.evict(item1);
		
		Item item2 = session1.get(Item.class, 3);
		
		System.out.println("*******************");
		System.out.println("item1: " + item1);
		System.out.println("item2: " + item2);
		System.out.println("*******************");

		return null;
//		return openSession().createNativeQuery(Q_GET_ITEM, Item.class)
//							.setParameter("MaMH", itemId, IntegerType.INSTANCE)
//							.uniqueResult();
	}
}
