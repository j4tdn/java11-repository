package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import persistence.ItemGroup;

public class HibernateItemGroupDao extends AbstractHibernateDao  implements ItemGroupDao  {
	
//	private String Q_GET_ALL = "SELECT ig FROM ItemGroup ig"; // Hibernate Query Languge
	
	public List<ItemGroup> getAll() {
		Session session = openSession();
//		NativeQuery<ItemGroup> query = null;
//		Transaction transaction =  session.beginTransaction();
		
		Query<ItemGroup> query = null;
		try {
//			 query =  session.createNativeQuery(Q_GET_ALL, ItemGroup.class);
			
//		    query =  session.createQuery(Q_GET_ALL, ItemGroup.class);
			
			query =  session.createNamedQuery(ItemGroup.Q_GET_ALL, ItemGroup.class);
		//	transaction.commit();
		}catch(Exception e) {
//			transaction.rollback();
		}
		
		return query.getResultList();
	}
	
	
}
