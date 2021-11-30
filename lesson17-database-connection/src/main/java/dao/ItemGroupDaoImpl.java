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
import utils.SqlUtils;

public class ItemGroupDaoImpl implements ItemGroupDao {

	
	
	private Connection connection;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public ItemGroupDaoImpl() {
		connection = DbManager.getConnection();
	}
	
	private static String Q_GET_ITEMS_BY_ITEM_GROUP_ID =
			  "SELECT  lh.MaLH AS '" + ItemGroupDto.ITEM_GROUP_ID + "',\n"
			+ "		   lh.TenLH AS '" + ItemGroupDto.ITEM_GROUP_NAME + "',\n"
			+ "        SUM(ctmh.SoLuong) SoLuongMatHang AS '" + ItemGroupDto.NUMBER_OF_ITEMS + "'\n"
			+ "FROM LoaiHang lh\n"
			+ "JOIN MatHang mh\n"
			+ "	ON lh.MaLH = mh.MaLH\n"
			+ "JOIN ChiTietMatHang ctmh\n"
			+ "	ON mh.MaMH = ctmh.MaMH\n"
			+ "GROUP BY lh.MaLH";

	public List<ItemGroup> getAll() {

		List<ItemGroup> result = new ArrayList<>();
		// 1. Write down a native query
		String sql = "SELECT * FROM LoaiHang";

		// 2. Execute the native query and return data
		try {
			// 2.1 Initial Statement||PrepareStatement object
			st = connection.createStatement();

			// 2.2 Pass native query into Statement||PrepareStatement and and execute native
			// query
			rs = st.executeQuery(sql);
			while (rs.next()) {
				// transformer
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

		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				// transformer
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
		// SQL Ịnjection
		String sql = "SELECT * FROM LoaiHang\n"
				   + "WHERE TenLH = ?";
		// SELECT * FROM LoaiHang
		// WHERE TenLH = '...' OR '1 = 1';
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemGroup itemGroup = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
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
	public boolean save(ItemGroup itemGroup) {
		boolean result = false;

		Integer id = itemGroup.getId();
		String name = itemGroup.getName();

		// UPDATE >> INSERT, UPDATE, DELETE
		String sql = "INSERT INTO LoaiHang (MaLH, TenLH)\n" + "VALUES(" + id + ", '" + name + "')";

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

		Integer id = itemGroup.getId();
		String name = itemGroup.getName();

		// UPDATE >> INSERT, UPDATE, DELETE
		String sql = "UPDATE LoaiHang  \n"
				   + "	 SET TenLH = ?  \n"
				   + "WHERE MaLh = ?";

		try {
			pst = connection.prepareStatement(sql);

			pst.setString(1, name);
			pst.setInt(2, id);
			
			int affectedRows = pst.executeUpdate();

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
		String sql = Q_GET_ITEMS_BY_ITEM_GROUP_ID;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				ItemGroupDto igDto = ItemGroupDto.addResultTransfomer(rs);
				result.add(igDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}

		return result;	}

}
