package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import persistence.ItemGroup;

public class HibernateItemGroupDao extends AbstractHibernateDao implements ItemGroupDao{
//	private String Q_GET_ALL = "SELECT MaLH, TenLH FROM LoaiHang"; // native sql
//	private String Q_GET_ALL = "FROM ItemGroup"; // hibernate query language HQL
	
	public List<ItemGroup> getAll() {
		
		Session session = getCurrentSession();
//		NativeQuery<ItemGroup> query = null;
//		Query<ItemGroup> query = null;
		Query<ItemGroup> query = null;
		
		Transaction transaction = session.beginTransaction();
		try {
//			query = session.createNativeQuery(Q_GET_ALL, ItemGroup.class);
//			query = session.createQuery(Q_GET_ALL, ItemGroup.class);
			query = session.createNamedQuery(ItemGroup.Q_GET_ALL, ItemGroup.class);
		} catch (Exception e) {
			transaction.rollback();
		}
		return query.getResultList();
	}
}
