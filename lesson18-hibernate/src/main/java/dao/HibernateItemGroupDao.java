package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import persistence.ItemGroup;

public class HibernateItemGroupDao extends AbstractHibernateDao implements ItemGroupDao{
	private final String Q_GET_ALL = "SELECT MaLH, TenLH FROM LoaiHang";
	public List<ItemGroup> getAll() {
		Session session = getCurrentSession();
		NativeQuery<ItemGroup> query = null;
		Transaction transaction = session.beginTransaction();
		
		try {
			// Unknown entity: persistence.itemGroup
			query = session.createNativeQuery(Q_GET_ALL, ItemGroup.class);
			//transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
		
		return query.getResultList();
	}
	
	public static void main(String[] args) {
		ItemGroupDao dao = new HibernateItemGroupDao();
		List<ItemGroup> itemGroups = dao.getAll();
		System.out.println("==============");
		System.out.println("size: " + itemGroups.size());
		for (ItemGroup itemGroup: itemGroups) {
			System.out.println(itemGroup);
		}
	}
}
