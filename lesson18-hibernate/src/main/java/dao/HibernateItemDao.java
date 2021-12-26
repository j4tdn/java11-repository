package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import persistence.Item;

public class HibernateItemDao extends AbstractHibernateDao implements ItemDao {

	private final String Q_GET_ALL = "SELECT ig FROM Item ig";
	// private final String Q_GET_ITEM = "SELECT * FROM MatHang WHERE = :MaMH";

	public List<Item> getAll() {
		Session session = openSession();
		Query<Item> query = session.createQuery(Q_GET_ALL, Item.class);
		return query.getResultList();
	}

	public Item getItem(int itemId) {
		/*
		return openSession().createNativeQuery(Q_GET_ITEM, Item.class).setParameter("MaMH", itemId, IntegerType.INSTANCE)
				.uniqueResult(); */
		// getSingleResult() || uniqueResult() || uniqueResultOptional() 
		
		// Hibernate API
		Session session1 = openSession();
		
		Item item1 = session1.get(Item.class, itemId);
		// Session session2 = openSession();
		// item1 
		// itemGroup#HibernateProxy1k2324
		
		session1.evict(item1);
		// session1.clear();
		
		Item item2 = session1.get(Item.class, itemId);
		
		System.out.println("**************************");
		System.out.println("item1: " + item1);
		System.out.println("item2: " + item2);
		System.out.println("**************************");
		
		return null;
	}

}
