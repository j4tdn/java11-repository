package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import persistence.ItemGroup;
import persistence.Item;

public class ItemDao extends AbstractHibernateDao{
	public void save(Item item) {
			Session session = utils.HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();
			try {
				session.save(item);

				Item result = session.get(Item.class, 12);
				Set<ItemGroup> itemGroups = result.getItemGroups();
				System.out.println(itemGroups);

			} catch (Exception e) {
				transaction.rollback();
			}

			transaction.commit();
		}

	public static List<Item> getItem() {
		List<Item> result = new ArrayList<>();
		Session session = utils.HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		try {
			String sql = "select lh.MaLoai, lh.TenLoai, mh.MaMH, mh.GiaBan, mh.GiaMua, mh.SoLuong \n" 
					+ "from mathang mh \n"  
					+ "join loaihang lh on mh.MaLoai = lh.MaLoai";
			NativeQuery<Item> query = session.createNativeQuery(sql, Item.class);
			query.getResultList();

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}


		return result;
	}

	public static List<String> getItemBuyBest(int year) {
		List<String> result = new ArrayList<>();
		Session session = utils.HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		try {
			String sql = "select * from mathang mh\r\n" + 
					"join chitietdonhang ctdh on mh.MaMH = ctdh.MaMH\n" + 
					"join donhang dh on dh.MaDH = ctdh.MaDH\n" + 
					"WHERE year(NgayTao) = " + year + "\n" + 
					"order by mh.SoLuong desc\n" + 
					"limit 3";
			NativeQuery<Item> query = session.createNativeQuery(sql, Item.class);
			query.getResultList();

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}

		return result;
	}
}