package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import persistence.ItemGroup;

public class HibernateItemGroupDao extends AbstractHibernateDao  implements ItemGroupDao  {
	
	private String Q_GET_ALL = "SELECT * FROM LoaiHang";
	
	public List<ItemGroup> getAll() {
		Session session = getCurrentSession();
		NativeQuery<ItemGroup> query = null;
		Transaction transaction =  session.beginTransaction();
		try {
			 query =  session.createNativeQuery(Q_GET_ALL, ItemGroup.class);
		//	transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
		}
		
		return query.getResultList();
	}
	
	
	public static void main(String[] args) {
		ItemGroupDao items = new HibernateItemGroupDao();
		List<ItemGroup> itemGroups = items.getAll();
		
		for(ItemGroup ig : itemGroups) {
			System.out.println(ig);
		}
	}

}
