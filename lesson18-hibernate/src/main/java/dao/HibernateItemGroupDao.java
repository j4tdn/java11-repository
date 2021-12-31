package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import persistence.ItemGroup;
import persistence.ItemGroupDto;

public class HibernateItemGroupDao extends AbstractHibernateDao implements ItemGroupDao {

	// private String Q_GET_ALL = "SELECT * FROM LoaiHang";
	// private String Q_GET_ALL = "FROM ItemGroup";

	@Override
	public List<ItemGroup> getAll() {
		Session session = openSession();

		// Transaction transaction = session.beginTransaction();
		// NativeQuery<ItemGroup> query = null;
		
		Query<ItemGroup> query = null;
		try {
			// Unknown entity: persistence.ItemGroup
			// query = session.createNativeQuery(Q_GET_ALL, ItemGroup.class);
			// query = session.createQuery(Q_GET_ALL, ItemGroup.class);

			query = session.createNamedQuery("Q_GET_ALL", ItemGroup.class);
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

}
