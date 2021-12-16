package dao;

import java.util.List;

<<<<<<< HEAD
=======
import org.hibernate.Session;

>>>>>>> 2651c26d (lesson18 - Hibernate 14.12.2021)
import persistence.Item;

public class HibernateItemDao extends AbstractHibernateDao implements ItemDao {

	
<<<<<<< HEAD
	private static final String Q_GET_ALL =  "SELECT * FROM MatHang";
	
	public List<Item> getAll(){
		return openSession().createNativeQuery(Q_GET_ALL, Item.class).getResultList();
	}
=======
	private static final String Q_GET_ALL = "SELECT * FROM MatHang";
	
	public List<Item> getAll(){
		Session session = openSession();
		
		 
		return session.createNativeQuery(Q_GET_ALL,Item.class).getResultList();
		
		

	} 
>>>>>>> 2651c26d (lesson18 - Hibernate 14.12.2021)
}
