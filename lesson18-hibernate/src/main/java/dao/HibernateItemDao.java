package dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.type.IntegerType;

import com.google.protobuf.Option;

import persistence.Item;

public class HibernateItemDao extends AbstractHibernateDao implements ItemDao{
	private static final String Q_GET_ALL="SELECT * FROM MatHang";
	private static final String Q_GET_ITEM="SELECT * FROM MatHang WHERE MaMH = :mamh";
	
	
	public List<Item> getAll() {
		Session session=openSession();
		return session.createNativeQuery(Q_GET_ALL,Item.class).getResultList();
	}

	//using native query | persistence query return entity with no cache
	/*public Item getItem(int itemId) {
		return 	openSession()
				.createNativeQuery(Q_GET_ITEM,Item.class)
				.setParameter("mamh", itemId,IntegerType.INSTANCE)
				.uniqueResult();
	}*/
	public Item getItem(int itemId) {
		Session sesion1=openSession();
		
		//Hibernate Api
		Item item1=openSession().get(Item.class, 3);
		//item1
		//itemGroup#HibernateProxy12xh11
		
		//sesion1.evict(item1);
		//sesion1.clear();
		Item item2=openSession().get(Item.class, 3);
		
		System.out.println("=======================");
		System.out.println("item1: "+item1);
		System.out.println("item1: "+item2);
		System.out.println("=======================");

		return null;
	}
	
}
