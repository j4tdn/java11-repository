package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import connection.DbProvider;
import persistence.ItemGroup;
import utils.SqUtils;

public class ItemGroupDaopl implements ItemGroupDao {

	private Connection connection;
	private Statement st;
	private ResultSet rs;

	public ItemGroupDaopl() {
		connection = DbManager.getConnection();
	}

	@Override
	public List<ItemGroup> getAll() {
		List<ItemGroup> result = new ArrayList<>();
		// 1. Write down a native query
		String sql = "Select MaLH, TenLH FROM LoaiHang";

		// 2. Execute the native query and return data
		try {

			// 2.1 Initial Statement||PrepareStatement object
			st = connection.createStatement();

			// 2.2 Set native query into Statement||PrepareStatement||Call
			// executeQuery||executeUpdate from Statement||PrepareStatement to execute
			// native query
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Integer id = rs.getInt("MaLH");
				String name = rs.getString("TenLH");
				ItemGroup itemGroup = new ItemGroup(id, name);
				result.add(itemGroup);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqUtils.close(rs, st);
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
				result = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			SqUtils.close(rs, st);
		}
		return result;
	}

	@Override
	public boolean save(ItemGroup itemGroup) {
		boolean result = false;
		Integer id = itemGroup.getId();
		String name = itemGroup.getName();
		String sql = "INSERT INTO LoaiHang(MaLH,TenLH)\n" + "VALUES(" + id + ",'" + name + "')";
		try {
			st = connection.createStatement();
			int affectedRows = st.executeUpdate(sql);
			result =affectedRows >0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqUtils.close(st);
		}
		return result;
	}

	@Override
	public boolean update(ItemGroup itemGroup) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdate(ItemGroup itemGroup) {
	    
		return true;
	}
}
