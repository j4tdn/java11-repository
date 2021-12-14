package dao;

import java.util.List;

import org.hibernate.Session;

import persistence.Item;

public class HibernateItemDao extends AbstractHibernateDao implements ItemDao{
	
	private static final String Q_GET_ALL = "SELECT * FROM MatHang";
	public List<Item> getAll() {
		Session session = openSession();
		
		return session.createNativeQuery(Q_GET_ALL, Item.class).getResultList();
	}
	
}
