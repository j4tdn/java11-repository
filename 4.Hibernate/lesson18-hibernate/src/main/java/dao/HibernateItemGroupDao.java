package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import persistence.ItemGroup;

public class HibernateItemGroupDao extends AbstractHibernateDao implements ItemGroupDao{
	
	//private String Q_GET_ALL = "SELECT MaLH,TenLH FROM LoaiHang"; /Native SQL
	//private String Q_GET_ALL = "SELECT ig FROM ItemGroup ig"; //HQL, JPQL
	
	public List<ItemGroup> getAll() {
		Session session = openSession();
	//	NativeQuery<ItemGroup> query = null;
	//	Transaction transaction = session.beginTransaction();
		
		Query<ItemGroup> query = null;
		try {
			
			//Unknown entity : persistance.ItemGroup
		//	query = session.createNativeQuery(Q_GET_ALL, ItemGroup.class);
			query = session.createNamedQuery(ItemGroup.Q_GET_ALL, ItemGroup.class);
			
		} catch (Exception e) {
	//		transaction.rollback();
			e.printStackTrace();
		}
		return query.getResultList();
	}
}
