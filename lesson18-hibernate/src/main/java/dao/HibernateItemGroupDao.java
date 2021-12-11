package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import persistence.ItemGroup;

public class HibernateItemGroupDao extends AbstractHibernateDao implements ItemGroupDao {

	private String Q_GET_ALL = "SELECT * FROM LoaiHang";
	
	@Override
	public List<ItemGroup> getAll() {
		Session session = getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		NativeQuery<ItemGroup> query = null;
		try {
			// unknown entity: persistence.itemGroup
			query = session.createNativeQuery(Q_GET_ALL, ItemGroup.class);
			
			//transaction.commit();
		}catch (Exception e) {
			transaction.rollback();
		}
		return query.getResultList();
	}
	
	public static void main(String[] args) {
		ItemGroupDao dao = new HibernateItemGroupDao();
		List<ItemGroup> itemGroups = dao.getAll();
		
		System.out.println("====================");
		for (ItemGroup itemGroup : itemGroups) {
			System.out.println(itemGroup);
		}
	}
}
