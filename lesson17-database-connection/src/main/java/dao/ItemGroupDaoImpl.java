package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DBManager;
import persistence.ItemGroup;
import utils.SqlUtils;

public class ItemGroupDaoImpl implements ItemGroupDao {
	private Connection connection;
	private Statement st;
	private PreparedStatement pstm;
	private ResultSet rs;

	public ItemGroupDaoImpl() {
		connection = DBManager.getConnection();
	}

	public List<ItemGroup> getAll() {
		// 1. Write down a native query
		String sql = "SELECT * FROM LoaiHang";

		// 2. Execute the native query and return data
		try {
			// 2.1 Initial Statement || PrepareStatement
			st = connection.createStatement();

			// 2.2 Pass native query into Statement || Call executeQuery || executeUpdate
			// from Statement || PrepareStatement to execute native query
			rs = st.executeQuery(sql);
			List<ItemGroup> result = new ArrayList<>();
			while (rs.next()) {
				Integer id = rs.getInt("MaLH");
				String name = rs.getString("TenLH");
				ItemGroup itemGroup = new ItemGroup(id, name);
				result.add(itemGroup);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return null;
	}

	@Override
	public List<ItemGroup> get(String name) {
		String sql = "SELECT * FROM LoaiHang WHERE TenLH = ?";
		List<ItemGroup> result = new ArrayList<>();
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, name);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ItemGroup itemGroup = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
				result.add(itemGroup);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st, pstm);
		}
		return result;
	}

	@Override
	public ItemGroup get(int id) {
		ItemGroup result = null;
		String sql = "SELECT * FROM LoaiHang " + "WHERE MaLH = " + id;
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
	public boolean save(ItemGroup itemGroup) {
		boolean result = false;

		// UPDATE >> INSERT, UPDATE, DELETE
		String sql = "INSERT INTO LoaiHang " + "VALUES(" + itemGroup.getId() + ",\'" + itemGroup.getName() + "\')";
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
		// UPDATE >> INSERT, UPDATE, DELETE
		boolean result = false;
		String sql = "UPDATE LoaiHang " + "SET TenLH = ? " + "WHERE MaLH = ? ";
		try {
			// prepare statement >> represent a preCompile SQL
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, itemGroup.getName());
			pstm.setInt(2, itemGroup.getId());

			int affectedRows = pstm.executeUpdate();
			result = affectedRows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(pstm);
		}
		return result;
	}

}
