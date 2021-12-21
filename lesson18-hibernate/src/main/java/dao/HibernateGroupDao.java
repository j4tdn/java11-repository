package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import persistence.ItemGroup;

public class HibernateGroupDao extends AbstractHibernateDao implements ItemGroupDao {
//	private String Q_GET_ALL = "SELECT * FROM LoaiHang";
	public List<ItemGroup> getAll() {
//		Session session = getCurrentSession();
//		NativeQuery<ItemGroup> query = null;
//		Transaction transaction = session.beginTransaction();
		
		Session session = openSession();
		Query<ItemGroup> query = null;
		try {
//			query = session.createNativeQuery(Q_GET_ALL, ItemGroup.class);
//			transaction.commit();
			query = session.createNamedQuery(ItemGroup.Q_GET_ALL, ItemGroup.class);
		} catch (Exception e) {
//			transaction.rollback();
			e.printStackTrace();
		}
		return query.getResultList();
	}

}
