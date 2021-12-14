package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import persistence.ItemGroup;

public class HibernateItemGroupDao extends AbstractHibernateDao implements ItemGroupDao{
	//private String Q_GET_ALL ="SELECT * FROM LoaiHang";
	//private String Q_GET_ALL = "FROM ItemGroup";
	
	public List<ItemGroup> getAll() {
		Session session = openSession();
		Transaction transacsion = session.beginTransaction();
		
		
		//NativeQuery<ItemGroup> query =null;
		Query<ItemGroup> query =null;
		try {
			//Unknow entity : persitence.ItemGroup
			//query= session.createNativeQuery(Q_GET_ALL, ItemGroup.class);
			//query = session.createQuery(Q_GET_ALL,ItemGroup.class);
			
			query = session.createNamedQuery(ItemGroup.Q_GET_ALL, ItemGroup.class);
			
			//transacsion.commit();
		} catch (Exception e) {
			transacsion.rollback();
		}
		
		return 	query.getResultList();
	
	}
	



}
