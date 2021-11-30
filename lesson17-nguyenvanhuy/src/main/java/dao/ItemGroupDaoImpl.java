package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistence.Item;
import utils.SqlUtils;



public class ItemGroupDaoImpl implements ItemGroupDao {

	private Connection connection;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public ItemGroupDaoImpl() {
		connection = DbManager.getConnection();
	}

	@Override
	public List<Item> getAll() {
		List<Item> result = new ArrayList<>();
		
		String sql = "SELECT  mh.MaMH, mh.TenMH, dh.ThoiGianDatHang\r\n"
				   + "FROM mathang mh "
				   + "JOIN chitietdonhang ctdh "
				   + "ON mh.MaMH = ctdh.MaMH\r\n"
				   + "JOIN donhang dh "
				   + "ON dh.MaDH = ctdh.MaDH\r\n"
				   + "WHERE CAST(thoigiandathang AS DATE) = '2019-11-23'";
		try {
			
			st = connection.createStatement();

			rs = st.executeQuery(sql);
			while (rs.next()) {
				// transformer
				Integer id = rs.getInt("MaMH");
				String name = rs.getString("TenMH");
				String color = rs.getString("MauSac");
				Item itemGroup = new Item(id, name, color);
				result.add(itemGroup);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}

		return result;
	}
	
}
