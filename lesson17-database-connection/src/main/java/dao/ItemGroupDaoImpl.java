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

public class ItemGroupDaoImpl implements ItemGroupDao{
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet rs;
	
	public ItemGroupDaoImpl() {
		connection = DBManager.getConnection();
	}
	
	@Override
	public List<ItemGroup> getAll() {
		List<ItemGroup> result = new ArrayList<>();
		// 1. Write down a native query
		String sql = "SELECT MaLH, TenLH FROM LoaiHang";
		
		// 2. Execute the native query and return data
		try {
			// 2.1 Initial Statement||PreparedStatement object & execute native query
			statement = connection.createStatement();
			// 2.2 Set native query into Statement||...
			rs = statement.executeQuery(sql);
			
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
			SqlUtils.close(rs, statement);
		}
		
		return result;
	}

	@Override
	public ItemGroup get(int id) {
		ItemGroup result = null;
		String sql = "SELECT * FROM LoaiHang\n"
					+ "WHERE MaLH = " + id;
		
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			
			if (rs.next()) {
				// transformer
				result = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, statement);
		}
		
		return result;
	}
	
	@Override
	public boolean saveOrUpdate(ItemGroup itemGroup) {
		return get(itemGroup.getId()) == null ? update(itemGroup) : save(itemGroup);
	}

	@Override
	public boolean save(ItemGroup itemGroup) {
		boolean result = false;
		String sql = "INSERT INTO LoaiHang(MaLH, TenLH) \n"
					+ "VALUES(?, ?)";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, itemGroup.getId());
			preparedStatement.setString(2, itemGroup.getName());
			result = preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs);
		}
		
		return result;
	}


	@Override
	public boolean update(ItemGroup itemGroup) {
		boolean result = false;
		String sql = "UPDATE LoaiHang \n"
					+ " SET TenLH = ? \n"
					+ " WHERE MaLH = ?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(2, itemGroup.getId());
			preparedStatement.setString(1, itemGroup.getName());
			int affectRows = preparedStatement.executeUpdate();
			result = affectRows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs);
		}
		
		return result;
	}
	
}
