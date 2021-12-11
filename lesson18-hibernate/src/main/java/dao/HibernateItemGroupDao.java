package dao;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import persistence.ItemGroup;

public class HibernateItemGroupDao extends AbstractHibernateDao implements ItemGroupDao {

	private String Q_GET_ALL = "SELECT * FROM LoaiHang";
	public List<ItemGroup> getAll() {
		
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		NativeQuery<ItemGroup> query = null;
		try {
			query = session.createNativeQuery(Q_GET_ALL, ItemGroup.class);
		} catch (Exception e) {
         transaction.rollback();
		}		
		
		return query.getResultList();
	}
	
	public static void main(String[] args) {
		ItemGroupDao dao = new HibernateItemGroupDao();
		
		List<ItemGroup> itemGroups = dao.getAll();
		
		System.out.println("==========================");
		System.out.println("size: " + itemGroups.size());
		for(ItemGroup itemGroup: itemGroups) {
			System.out.println(itemGroup);
		}
	}
}
