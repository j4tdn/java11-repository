package dao;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import persistence.ItemGroup;
import persistence.ItemGroupDto;

public class HibernateItemGroupDao extends AbstractHibernateDao implements ItemGroupDao{
	
	// private String Q_GET_ALL = "SELECT MaLH, TenLH FROM LoaiHang"; // Native SQL
	// private String Q_GET_ALL = "SELECT ig FROM ItemGroup ig"; // JPQL, HQL
	
	private static String Q_GET_ITEMS_BY_ITEM_GROUP_ID = "SELECT  lh.MaLH		" 	+ ItemGroupDto.ITEM_GROUP_ID + ",\n"
														+ "	lh.TenLH		" 		+ ItemGroupDto.ITEM_GROUP_NAME + ", \n" 
														+ " SUM(ctmh.SoLuong)" 		+ ItemGroupDto.NUMBER_OF_ITEMS + "\n" 
														+ "FROM LoaiHang lh\n" 		
														+ "JOIN MatHang mh\n"
														+ "	ON lh.MaLH = mh.MaLH\n"
														+ "JOIN ChiTietMatHang ctmh\n" + "	ON mh.MaMH = ctmh.MaMH\n"
														+ "GROUP BY lh.MaLH";
	
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
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<ItemGroupDto> getItemByItemGroupId() {
		
		return  openSession().createNativeQuery(Q_GET_ITEMS_BY_ITEM_GROUP_ID)
				.addScalar(ItemGroupDto.ITEM_GROUP_ID , IntegerType.INSTANCE)
				.addScalar(ItemGroupDto.ITEM_GROUP_NAME , StringType.INSTANCE)
				.addScalar(ItemGroupDto.NUMBER_OF_ITEMS, IntegerType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(ItemGroupDto.class ))
				.getResultList();
		
	}
	
	public void demoSlvCache() {
		
		Session session1 = openSession(); 
		Session session2 = openSession(); 
		
		
		// 1. Load from database
		ItemGroup igA = session1.get(ItemGroup.class,5 );
		System.out.println("igA: "+igA);
		
		// 2. First level cache with session1
		ItemGroup igB = session1.get(ItemGroup.class,5 );
		System.out.println("igB: "+igB);
		
		// 3. Load from database
		ItemGroup igC = session2.get(ItemGroup.class,2 );
		System.out.println("igC: "+igC);
		
		// 4.Second level cache  - Cache provider 
		// session1 : ItemGroup5 - Cache region
		// session2 : ItemGroup2 - Cache region
		utils.SqlUtils.breakLine("=======================");
		
		// timeToIdleSeconds="3"
		sleep(3);
		ItemGroup igD = session2.get(ItemGroup.class,5 );
		System.out.println("igD: "+igD);
		
	}
	
	private static void sleep(long seconds) {
		
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}