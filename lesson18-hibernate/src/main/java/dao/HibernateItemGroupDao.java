package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import persistence.ItemGroup;

public class HibernateItemGroupDao extends AbstractHibernateDao implements ItemGroupDao {
	public static String Q_GET_ALL = "SELECT * FROM LoaiHang";
	
	public List<ItemGroup> getAll() {
		Session session = getCurrentSession();
		Transaction transaction = session.beginTransaction();
		NativeQuery<ItemGroup> query = null;
		try {
			//Unknown entity : persistence.ItemGroup
			query = session.createNativeQuery(Q_GET_ALL, ItemGroup.class);
			
			//use when manipulation data
			//transaction.commit();s
		} catch(Exception e)  {
			transaction.rollback();
		}
		return query.getResultList();
	}
	
	public static void main(String[] args) {
		ItemGroupDao dao = new HibernateItemGroupDao();
		
		List<ItemGroup> itemGroups = dao.getAll();
		
		System.out.println("===============");
		for(ItemGroup ig : itemGroups) {
			System.out.println(ig);
		}
	}
}
