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
			SqlUtils.close(rs, st);
		}

		return result;
	}

	@Override
	public ItemGroup get(int id) {
		ItemGroup result = null;
		String sql = "SELECT * FROM LoaiHang\n"
					+ "WHERE MaLH = " + id;

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
		Integer id = itemGroup.getId();
		String name = itemGroup.getName();

		// UPDATE >> INSERT, DELETE, UPDATE DATA
		String sql = "INSERT INTO LoaiHang(MaLH, TenLH)\n" 
				+ "VALUES (" + id + ", \" " + name + "\")";

		try {
			// statement >> execute complete SQL statement with parameters
			st = connection.createStatement();
			result = st.executeUpdate(sql) > 0;
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

		// UPDATE >> INSERT, DELETE, UPDATE DATA
		String sql = "UPDATE LoaiHang \n" 
				   + "SET TenLH = ? \n"
				   + "WHERE MaLH = ?";
		try {
			// prepare statement >> represent a preComplie SQL statement and pass the parameter then
			pst = connection.prepareStatement(sql);
			
			// set parameter, complete SQL with parameter
			pst.setString(1, name);
			pst.setInt(2, id);
			result = pst.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(st);
		}

		return result;
	}

	// 1. SQL(Statement) >> complicated in case of many parameters
	// 2. save => saveOrUpdate

}