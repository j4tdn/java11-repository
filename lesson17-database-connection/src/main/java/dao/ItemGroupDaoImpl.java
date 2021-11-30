package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import connection.DbManager;
import persistence.ItemGroup;
import persistence.ItemGroupDto;
import util.SqlUtils;

public class ItemGroupDaoImpl implements ItemGroupDao {
	private Connection connection;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public ItemGroupDaoImpl() {
		connection = DbManager.getConnection();
	}

	
	private static String Q_GETS_ITEMS_ITEM_GROUP_ID =
						"SELECT  lh.MaLH AS "+ ItemGroupDto.ITEM_GROUP_ID + ",\n"
					+ "		lh.TenLH AS " + ItemGroupDto.ITEM_GROUP_NAME + ",\n"
					+ "     SUM(ctmh.SoLuong) AS " + ItemGroupDto.ITEM_GROUP_NUMBER_OF_ITEMS + "\n"
					+ "FROM LoaiHang lh\n"
					+ "JOIN MatHang mh\n"
					+ "	 ON lh.MaLH = mh.MaLH\n"
					+ "JOIN ChiTietMatHang ctmh\n"
					+ "	 ON mh.MaMH = ctmh.MaMH\n"
					+ "GROUP BY lh.MaLH";
	
	
	@Override
	public List<ItemGroup> getAll() {
		List<ItemGroup> result = new ArrayList<>();

		// 1. Write down a native query
		String sql = "SELECT * FROM LoaiHang";

		// 2. Execute the native query and return data

		// 2.1 Initial Statement || PrepareStatement object
		try {
			st = connection.createStatement();
			// 2.2 Set native query into Statement || PrepareStatement & call executeQrery||
			// executeUpdate native query
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Integer id = rs.getInt("MaLH");
				String name = rs.getString("TenLH");
				ItemGroup itemGroup = new ItemGroup(id, name);
				result.add(itemGroup);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}

		return result;
	}

	@Override
	public ItemGroup get(int id) {
		ItemGroup result = null;

		String sql = "SELECT * FROM LoaiHang\n" + "WHERE MaLH = " + id;

		// 2. Execute the native query and return data

		// 2.1 Initial Statement || PrepareStatement object
		try {
			st = connection.createStatement();
			// 2.2 Set native query into Statement || PrepareStatement & call executeQrery||
			// executeUpdate native query
			rs = st.executeQuery(sql);
			if (rs.next()) {
				result = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}

		return result;
	}

	@Override
	public List<ItemGroup> get(String name) {
		List<ItemGroup> result = new ArrayList<>();

		String sql = "SELECT * FROM LoaiHang\n"
				+ "WHERE TenLH = '" + name + "'";


		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				ItemGroup itemGroup = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
				result.add(itemGroup);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		
		return null;
	}
	
	
	@Override
	public boolean save(ItemGroup itemGroup) {
		boolean result = false;

		// Update >> INSERT, UPDATE, DELETE
		String sql = "INSERT INTO LoaiHang(MaLH, TenLH)\n" + "VALUES(" + itemGroup.getId() + ", '" + itemGroup.getName()
				+ "' )";

		// 2. Execute the native query and return data

		// 2.1 Initial Statement || PrepareStatement object
		try {
			st = connection.createStatement();
			int affectedRows = st.executeUpdate(sql);
			result = affectedRows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(st);
		}

		return result;
	}



	@Override
	public boolean update(ItemGroup itemGroup) {
		boolean result = false;

		// Update >> INSERT, UPDATE, DELETE
		String sql = "UPDATE LoaiHang \n"
				+ " SET TenLH = ? \n"
				+ "WHERE MaLH = ?";

		try {
			pst = connection.prepareCall(sql);
			
			pst.setString(1, itemGroup.getName());
			pst.setInt(2, itemGroup.getId());
			
			int affectedRows = pst.executeUpdate(sql);
			result = affectedRows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(pst);
		}

		return result;
	}

	@Override
	public List<ItemGroupDto> getItemsByItemGroupId() {
		List<ItemGroupDto> result = new ArrayList<>();

		
		try {
			st = connection.createStatement();
			rs = st.executeQuery(Q_GETS_ITEMS_ITEM_GROUP_ID);
			while (rs.next()) {
				// transformer
				result.add(ItemGroupDto.addResultTransformer(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}

		return result;
	}
	

}
