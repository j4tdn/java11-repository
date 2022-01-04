package dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.type.IntegerType;

import persistence.Item;

public class HibernateItemDao extends AbstractHibernateDao implements ItemDao {

	private static final String Q_GET_ALL = "SELECT * FROM MatHang";
	private static final String Q_GET_ITEM = "SELECT * FROM MatHang WHERE MaMH= :mamh";

	public List<Item> getAll() {
		Session session = openSession();

		return session.createNativeQuery(Q_GET_ALL, Item.class).getResultList();
	}

	// Using native query,
	public Item getItem(int itemId) {
		Session session1 = openSession();

		//Optional<Item> opt = session1.createNativeQuery(Q_GET_ITEM, Item.class)
		//		.setParameter("mamh", itemId, IntegerType.INSTANCE).uniqueResultOptional();
		
		//hibernate api
		Item item1 = session1.get(Item.class, itemId);
		//item1
		//session1.evict(item1);
		//session1.clear();
		
		Item item2 = session1.get(Item.class, itemId);
		
		System.out.println("***********************************");
		System.out.println("Item1 >> "+ item1.toString());
		System.out.println("Item2 >> "+ item2.toString());
		System.out.println("***********************************");
		
		//return opt.isPresent() ? opt.get() : null;
		return item1;
	}

}
