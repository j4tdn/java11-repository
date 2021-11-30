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
import persistence.ItemGroup;
import persistence.ItemGroupDto;

import static utils.SqlUtils.*;

public class ItemGroupDaoImpl implements ItemGroupDao {

	private Connection connection;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public ItemGroupDaoImpl() {
		connection = DbManager.getConnection();
	}

	@Override
	public List<ItemGroup> getAll() {
		List<ItemGroup> result = new ArrayList<>();
		// 1. Write down a native query
		String sql = "SELECT * FROM LoaiHang";

		// 2. Execute the native query and return data
		try {
			// 2.1 Initial Statement || PrepareStatement object
			st = connection.createStatement();
			// 2.2 Pass native query into Statement || PrepareStatement & call
			// executeQuery||executeUpdate to execute native query
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
			close(rs, st);
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
			close(rs, st);
		}

		return result;
	}

	@Override
	public List<ItemGroup> get(String name) {
		List<ItemGroup> result = new ArrayList<>();
		// SQL Injection
		String sql = "SELECT * FROM LoaiHang\n" + "WHERE TenLH = ?";
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
			close(rs, st);
		}

		return result;
	}

	@Override
	public boolean save(ItemGroup itemGroup) {
		boolean result = false;
		Integer id = itemGroup.getId();
		String name = itemGroup.getName();

		// UPDATE >> INSERT, DELETE, UPDATE DATA
		String sql = "INSERT INTO LoaiHang(MaLH, TenLH)\n" + "VALUES (" + id + ", \" " + name + "\")";

		try {
			// statement >> execute complete SQL statement with parameters
			st = connection.createStatement();
			result = st.executeUpdate(sql) > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(st);
		}

		return result;
	}

	@Override
	public boolean update(ItemGroup itemGroup) {
		boolean result = false;
		Integer id = itemGroup.getId();
		String name = itemGroup.getName();

		// UPDATE >> INSERT, DELETE, UPDATE DATA
		String sql = "UPDATE LoaiHang \n" + "SET TenLH = ? \n" + "WHERE MaLH = ?";
		try {
			// prepare statement >> represent a preComplie SQL statement and pass the
			// parameter then
			pst = connection.prepareStatement(sql);

			// set parameter, complete SQL with parameter
			pst.setString(1, name);
			pst.setInt(2, id);
			result = pst.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(st);
		}

		return result;
	}

	// 1. SQL(Statement) >> complicated in case of many parameters
	// 2. save => saveOrUpdate

	@Override
	public List<ItemGroupDto> getItemsByItemGroupId() {
		List<ItemGroupDto> result = new ArrayList<>();
		String sql = "SELECT lh.MaLH AS 					 	 " + ItemGroupDto.ITEM_GROUP_ID + ",\n"
				+ "		 lh.TenLH AS						 " + ItemGroupDto.ITEM_GROUP_NAME + ",\n"
				+ "       SUM(ctmh.SoLuong) AS   			 " + ItemGroupDto.NUMBER_OF_ITEMS + "\n"
				+ "FROM LoaiHang lh\n" + "JOIN MatHang mh\n" + "	ON lh.MaLH = mh.MaLH\n"
				+ "JOIN ChiTietMatHang ctmh\n" + "	ON mh.MaMH = ctmh.MaMH\n" + "GROUP BY lh.MaLH";
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(addResultTransfomer(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, st);
		}
		return result;
	}

	public static ItemGroupDto addResultTransfomer(ResultSet rs) throws SQLException {
		return new ItemGroupDto(rs.getInt(ItemGroupDto.ITEM_GROUP_ID), rs.getString(ItemGroupDto.ITEM_GROUP_NAME),
				rs.getLong(ItemGroupDto.NUMBER_OF_ITEMS));
	}

	@Override
	public List<ItemGroupDto> getItemGroup() {
		List<ItemGroupDto> result = new ArrayList<>();
		String sql = "SELECT lh.MaLH AS 					 	 " + ItemGroupDto.ITEM_GROUP_ID + ",\n"
				+ "		 lh.TenLH AS						 " + ItemGroupDto.ITEM_GROUP_NAME + ",\n"
				+ "       SUM(ctmh.SoLuong) AS   			 " + ItemGroupDto.NUMBER_OF_ITEMS + "\n"
				+ "FROM LoaiHang lh\n" + "JOIN MatHang mh\n" + "	ON lh.MaLH = mh.MaLH\n"
				+ "JOIN ChiTietMatHang ctmh\n" + "	ON mh.MaMH = ctmh.MaMH\n" + "WHERE mh.MaMH NOT IN("
				+ "SELECT MaMH\n" + "FROM chitietdonhang)" + "GROUP BY lh.MaLH";
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(addResultTransfomer(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, st);
		}
		return result;
	}

}