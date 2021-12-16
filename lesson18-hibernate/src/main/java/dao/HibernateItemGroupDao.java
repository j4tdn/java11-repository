package dao;

import java.util.List;

import org.hibernate.Session;
<<<<<<< HEAD
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
=======
>>>>>>> 2651c26d (lesson18 - Hibernate 14.12.2021)
import org.hibernate.query.Query;

import persistence.ItemGroup;

public class HibernateItemGroupDao extends AbstractHibernateDao implements ItemGroupDao{
	
<<<<<<< HEAD
	//private String Q_GET_ALL = "SELECT MaLH, TenLH FROM LoaiHang"; // NATIVE SQL
	
	// private String Q_GET_ALL = "SELECT ig FROM ItemGroup ig";// HQL
	public List<ItemGroup> getAll() {
		Session session = openSession();
//		Transaction transaction = session.beginTransaction();
		
//		NativeQuery<ItemGroup> query = null;
		
=======
	//private String Q_GET_ALL = "SELECT MaLH, TenLH FROM LoaiHang"; // NATIVE SQL -- cause 1;
	
	 //private String Q_GET_ALL = "FROM ItemGroup ";// HIBERNATE QUERY LANGUAGE -- cause 2;
	 
	 //	 private String Q_GET_ALL = "SELECT IG FROM ItemGroup IG ";// HIBERNATE QUERY LANGUAGE -- cause 2;

	public List<ItemGroup> getAll() {
		Session session = openSession();
//		Transaction transaction = session.beginTransaction();
		
	//	NativeQuery<ItemGroup> query = null; --NATIVE QUERY
		
	//	Query<ItemGroup> query = null; -- HQL 
		
>>>>>>> 2651c26d (lesson18 - Hibernate 14.12.2021)
		Query<ItemGroup> query = null;
		try {
			//  Unknown entity: persistence.ItemGroup
			
<<<<<<< HEAD
			// query = session.createNativeQuery(Q_GET_ALL, ItemGroup.class);
			
			// query = session.createQuery(Q_GET_ALL, ItemGroup.class);
=======
			// query = session.createNativeQuery(Q_GET_ALL, ItemGroup.class); -- NATIVE QUERY
			
			// query = session.createQuery(Q_GET_ALL, ItemGroup.class); -- HQL
>>>>>>> 2651c26d (lesson18 - Hibernate 14.12.2021)
			
			query = session.createNamedQuery(ItemGroup.Q_GET_ALL, ItemGroup.class);
			
			// transaction.commit();
		} catch (Exception e) {
//			transaction.rollback();
			e.printStackTrace();
			
		}
		
		return query.getResultList();
	}
	
<<<<<<< HEAD
=======
	
>>>>>>> 2651c26d (lesson18 - Hibernate 14.12.2021)
}