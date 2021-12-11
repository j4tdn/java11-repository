package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import persistence.ItemGroup;

public class HibernateItemGroupDao extends AbstractHibernateDao implements ItemGroupDao{
	private String Q_GET_ALL ="SELECT * FROM LoaiHang";

	public List<ItemGroup> getAll() {
		Session session = getCurrentSession();
		Transaction transacsion = session.getTransaction();
		
		
		NativeQuery<ItemGroup> query =null;
		try {
			query= session.createNativeQuery(Q_GET_ALL, ItemGroup.class);
			
			//transacsion.commit();
		} catch (Exception e) {
			transacsion.rollback();
		}
		
		return 	query.getResultList();
	}
	
	public static void main(String[] args) {
		ItemGroupDao dao = new HibernateItemGroupDao();
		List<ItemGroup> itemGroups = dao.getAll();
		
		System.out.println("=============");
		System.out.println("size: " + itemGroups.size());
		
		for(ItemGroup itemGroup : itemGroups) {
			System.out.println(itemGroup);
		}
	}


}
