package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import persistence.ItemGroup;

public class HibernateItemGroupDao extends AbstractHibernateDao implements ItemGroupDao{
	
	// private String Q_GET_ALL = "SELECT MaLH, TenLH FROM LoaiHang"; // Native SQL
	// private String Q_GET_ALL = "SELECT ig FROM ItemGroup ig"; // JPQL, HQL
	
	public List<ItemGroup> getAll() {
		Session session = openSession();
		// Transaction transaction = session.beginTransaction();
		
		// NativeQuery<ItemGroup> query = null;
		// Query<ItemGroup> query = null;
		Query<ItemGroup> query = null;
		try {
			//  Unknown entity: persistence.ItemGroup
			// query = session.createNativeQuery(Q_GET_ALL, ItemGroup.class);
			// query = session.createQuery(Q_GET_ALL, ItemGroup.class);
			
			query = session.createNamedQuery(ItemGroup.Q_GET_ALL, ItemGroup.class);
			
			// transaction.commit();
		} catch (Exception e) {
			// transaction.rollback();
			e.printStackTrace();
		}
		
		return query.getResultList();
	}
	
}