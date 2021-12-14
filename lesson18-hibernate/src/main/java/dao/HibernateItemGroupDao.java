package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import persistence.ItemGroup;

public class HibernateItemGroupDao extends AbstractHibernateDao implements ItemGroupDao{
	
	// private String Q_GET_ALL = "SELECT MaLH, TenLH FROM LoaiHang";
	   
	  // private String Q_GET_ALL = "FROM ItemGroup";
	   
	   
	private Query<ItemGroup>  query;

	public List<ItemGroup> getAll() {
		Session session = openSession();
		// Transaction transaction = session.beginTransaction();
		
		 query = null;
		try {
			//  Unknown entity: persistence.ItemGroup
			// query = session.createNativeQuery(Q_GET_ALL, ItemGroup.class);
			// session.createQuery(Q_GET_ALL, ItemGroup.class);
			
			session.createNamedQuery(ItemGroup.Q_GET_ALL, ItemGroup.class);
			// transaction.commit();
		} catch (Exception e) {
			// transaction.rollback();
			e.printStackTrace();
		}
		
		return query.getResultList();
	}
}