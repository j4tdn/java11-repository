package dao;

import java.util.List;

import org.hibernate.Session;

import persistence.Item;

public class HibernateItemDao extends AbstractHibernateDao implements ItemDao{
	private static final String Q_GET_ALL  = "SELECT * FROM MatHang";
	// private static final String Q_GET_ITEM = "SELECT * FROM MatHang WHERE MaMH = :MaMH";
	
	@Override
	public List<Item> getAll() {
		return openSession()
			   .createNativeQuery(Q_GET_ALL, Item.class)
			   .getResultList();
	}
	
	@Override
	public Item getItem(int id) {
		Session session1 = openSession();
		// Session session2 = openSession();
		// Hibernate0-API
		
		Item item1 = session1.get(Item.class, 2);
		// item1
		// itemGroup#HibernateProxy12xh11
		
		// session1.evict(item1); // OK
		// session2.clear(); // clear session
		
		Item item2 = session1.get(Item.class, 2);
		
		System.out.println("************************************");
		System.out.println("item1: " + item1);
		System.out.println("item2: " + item2);		
		System.out.println("************************************");
		
		
		return null;
	}
}
