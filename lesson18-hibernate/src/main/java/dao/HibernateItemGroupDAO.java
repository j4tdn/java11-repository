package dao;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import persistence.ItemGroup;
import persistence.ItemGroupDto;

public class HibernateItemGroupDao extends AbstractHibernateDao implements ItemGroupDao{
	
	// private String Q_GET_ALL = "SELECT MaLH, TenLH FROM LoaiHang"; // Native SQL
	// private String Q_GET_ALL = "SELECT ig FROM ItemGroup ig"; // JPQL, HQL
	
	public List<ItemGroup> getAll() {
		Session session = openSession();
		// Transaction transaction = session.beginTransaction();
		
		// NativeQuery<ItemGroup> query = null;
		// Query<ItemGroup> query = null;
		Query<ItemGroup> query = null;
		try {
			//  Unknown entity: persistence.ItemGroup
			// query = session.createNativeQuery(Q_GET_ALL, ItemGroup.class);
			// query = session.createQuery(Q_GET_ALL, ItemGroup.class);
			
			query = session.createNamedQuery(ItemGroup.Q_GET_ALL, ItemGroup.class);
			
			// transaction.commit();
		} catch (Exception e) {
			// transaction.rollback();
			e.printStackTrace();
		}
		
		return query.getResultList();
	}
	
	private static String Q_GET_ITEMS_BY_ITEM_GROUP_ID = 
			  "SELECT lh.MaLH           " + ItemGroupDto.ITEM_GROUP_ID   + ", \n"
			+ "		  lh.TenLH          " + ItemGroupDto.ITEM_GROUP_NAME + ", \n"
			+ "       SUM(ctmh.SoLuong) " + ItemGroupDto.NUMBER_OF_ITEMS + "\n"
			+ "FROM LoaiHang lh \n"
			+ "JOIN MatHang mh  \n"
			+ "	 ON lh.MaLH = mh.MaLH   \n"
			+ "JOIN ChiTietMatHang ctmh \n"
			+ "	 ON mh.MaMH = ctmh.MaMH \n"
			+ "GROUP BY lh.MaLH";
	
	// .addScalar(ItemGroupDto.ITEM_GROUP_ID, IntegerType.INSTANCE)
	// Integer value = getInt(ItemGroupDto.ITEM_GROUP_ID)
			
	//.setResultTransformer(Transformers.aliasToBean(ItemGroupDto.class))
	// Creates a ResultTransformer that will inject aliased values into instances of Class via property methods or fields.
	// (ItemGroupDto)instance.setIgId(value);
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<ItemGroupDto> getItemsByItemGroupId() {
		return openSession().createNativeQuery(Q_GET_ITEMS_BY_ITEM_GROUP_ID)
				.addScalar(ItemGroupDto.ITEM_GROUP_ID, IntegerType.INSTANCE)
				.addScalar(ItemGroupDto.ITEM_GROUP_NAME, StringType.INSTANCE)
				.addScalar(ItemGroupDto.NUMBER_OF_ITEMS, IntegerType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(ItemGroupDto.class))
				.getResultList();
	}
	
	public void demoSlvCache() {
		Session session2 = openSession();
		Session session1 = openSession();
		
		// session1 can use cache data from session2
		// but vice versa is rejected
		
		// 1. Load from database
		ItemGroup igA = session1.get(ItemGroup.class, 4);
		System.out.println("igA: " + igA);
		
		// 2. First Level Cache with session1
		ItemGroup igB = session1.get(ItemGroup.class, 4);
		System.out.println("igB: " + igB);
		
		// 3. Load from database
		ItemGroup igC = session2.get(ItemGroup.class, 6);
		System.out.println("igC: " + igC);
		
		// timeToIdleSeconds="3"
		sleep(5); // take greater than 3 seconds >>> load from database
		          // else >> use data from cache
		
		// 4. Second Level Cache > Cache Provider
		// session1: ItemGroup-4 > Cache Region
		// session2: ItemGroup-6 > Cache Region
		ItemGroup igD = session1.get(ItemGroup.class, 6);
		System.out.println("igD: " + igD);
	}
	
	private static void sleep(long seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
