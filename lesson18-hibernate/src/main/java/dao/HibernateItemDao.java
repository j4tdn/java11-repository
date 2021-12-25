package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.type.IntegerType;

import persistence.Item;

public class HibernateItemDao extends AbstractHibernateDao implements ItemDao {

	private static final String Q_GET_ALL = "SELECT * FROM MatHang";
	private static final String Q_GET_ITEM = "SELECT * FROM MatHang WHERE MaMH = :MaMH";
	
	public List<Item> getAll() {
		return openSession().createNativeQuery(Q_GET_ALL, Item.class).getResultList();
	}
	
	// Using native query | persistence query return entity with no cache 
	public Item getItem(int itemId) {
		Session session1 = openSession();
		// Session session2 = openSession();
		
		// Hibernate API
		Item item1 = session1.get(Item.class, 3);
		// item1
		// itemGroup#HibernateProxy12xh11
		
		// session1.evict(item1): //OK
		// session1.clear(); // clear session
		Item item2 = session1.get(Item.class, 3);
		
		
		System.out.println("*************************");
		System.out.println("item1: " + item1);
		System.out.println("item2: " + item2);
		System.out.println("*************************");
		
		return null;
	}
	
}
