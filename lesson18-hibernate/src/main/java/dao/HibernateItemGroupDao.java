package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import persistence.ItemGroup;
import persistence.ItemGroupDto;

public class HibernateItemGroupDao extends AbstractHibernateDao implements ItemGroupDao{
	
	//Native SQL
	//private String Q_GET_ALL="SELECT * FROM LoaiHang"; 
	
	//JPL, HQL
	//private String Q_GET_ALL = "FROM ItemGroup";  
	
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
	
	public List<ItemGroup> getAll() {
		Session session =getCurrentSession();
		// NativeQuery<ItemGroup>query = null;
		
		Query<ItemGroup> query = null;
		Transaction transaction= session.beginTransaction();
		try {
			//query= session.createNativeQuery(Q_GET_ALL, ItemGroup.class);
			//query = session.createQuery(Q_GET_ALL, ItemGroup.class);
			
			query =session.createNamedQuery(ItemGroup.Q_GET_ALL,ItemGroup.class);
			
			//Ko dung lenh commit voi Select
			//transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		
		
		return query.getResultList();
	}
	
	public static void main(String[] args) {
			ItemGroupDao dao = new HibernateItemGroupDao();
			List<ItemGroup> ItemGroups =dao.getAll();
			
			System.out.println("===============");
			for(ItemGroup itemGroup: ItemGroups) {
				System.out.println(itemGroup);
			}
	}

	
		/*
		 * addScalar(ItemGroupDto.ITEM_GROUP_ID, IntegerType.INSTANCE)
		 ~ Integer value = getInt(ItemGroupDto.ITEM_GROUP_ID)
		 */
		/**
		 * setResultTransformer(Transformers.aliasToBean(ItemGroupDto.class))
		 *	Creates a ResultTransformer that will inject aliased values into instances of Class via property methods or fields.
		 *	~(ItemGroupDto)instance.setIgId(value);
		 */
 
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<ItemGroupDto> getItemsByItemGroupId() {
		return openSession().createNativeQuery(Q_GET_ITEMS_BY_ITEM_GROUP_ID)
							.addScalar(ItemGroupDto.ITEM_GROUP_ID,IntegerType.INSTANCE)
							.addScalar(ItemGroupDto.ITEM_GROUP_NAME,StringType.INSTANCE)
							.addScalar(ItemGroupDto.NUMBER_OF_ITEMS,IntegerType.INSTANCE)
							.setResultTransformer(Transformers.aliasToBean(ItemGroupDto.class))	
							.getResultList();
	}

	public void demoSlvCache() {
		Session session1=openSession();
		Session session2=openSession();
		
		//1. Load from DB
		ItemGroup igA= session1.get(ItemGroup.class,4);
		System.out.println("igA: "+igA);
		
		//2. First level cache with session 1
		ItemGroup igB= session1.get(ItemGroup.class,4);
		System.out.println("igB: "+igB);
		
		//3. Load from DB
		ItemGroup igC= session2.get(ItemGroup.class,6);
		System.out.println("igC: "+igC);
	
		//4. Second level cache
		//session1: Itemgroup - 4 > cache provider
		//session2: Itemgroup - 4 > cache provider
		ItemGroup igD= session2.get(ItemGroup.class,6);
		System.out.println("igD: "+igD);
	}
	
	
}
