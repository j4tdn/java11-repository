package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import persistence.ItemGroup;

public class HibernateItemGroupDao extends AbstractHibernateDao implements ItemGroupDao {

	//private String Q_GET_ALL = "SELECT * FROM LoaiHang"; // native SQL
	//private String Q_GET_ALL = "SELECT id, name FROM ItemGroup"; //JPQL, HQL
	
	@Override
	public List<ItemGroup> getAll() {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		
		//NativeQuery<ItemGroup> query = null;
		Query<ItemGroup> query = null;
		try {
			// unknown entity: persistence.itemGroup
			//query = session.createNativeQuery(Q_GET_ALL, ItemGroup.class);
			//session.createQuery(Q_GET_ALL, ItemGroup.class);
			query = session.createNamedQuery(ItemGroup.Q_GET_ALL, ItemGroup.class);
			//transaction.commit();
		}catch (Exception e) {
			//transaction.rollback();
			e.printStackTrace();
		}
		return query.getResultList();
	}
	
	
}
