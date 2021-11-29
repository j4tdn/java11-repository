package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistence.Item;
import persistence.ItemGroup;
import utils.DateUtils;
import utils.sqlUtils;

public class ItemDaoImpl implements ItemDao {

	private final Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	private static String Q_GET_ITEMS_BY_ITEM_GROUP_ID = "select distinct * from mathang as m inner join chitietdonhang as cd on m.mamh = cd.mamh inner join donhang as dh on dh.madh = cd.madh where cast(dh.thoigiandathang as date)  = ?";

	public ItemDaoImpl() {
		con = DbManager.getConnection();
	}

	@Override
	public List<Item> getItemByItemGroupName(String igname) {
		String sql = "select * from mathang as m inner join loaihang as l on m.malh=l.malh where l.tenlh = ?";
		List<Item> list = new ArrayList<>();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, igname);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Item(rs.getInt("mamh"), rs.getString("tenmh"), rs.getString("mausac"),
						new ItemGroup(rs.getInt("malh"), rs.getString("tenlh"))));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlUtils.close(rs, pst);
		}

		return list;
	}

	@Override
	public List<Item> get(LocalDate orderDate) {
		List<Item> list = new ArrayList<>();
		try {
			pst = con.prepareStatement(Q_GET_ITEMS_BY_ITEM_GROUP_ID);
			pst.setDate(1, DateUtils.toSqlDate(orderDate));
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Item(rs.getInt("mamh"), rs.getString("tenmh"), rs.getString("mausac")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlUtils.close(rs, pst);
		}

		return list;
	}

}
