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
	
	private Connection connecton;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ItemGroupDaoImpl() {
		connecton = DbManager.getConnection();
	}
	
	@Override
	public List<ItemGroup> getALL() {
		List<ItemGroup> result = new ArrayList<>();
		
		// 1. Write down a native query
		String sql = "SELECT * FROM LoaiHang";
		
		// 2. Execute the native query and return data
		try {
			// 2.1 Initial Statement || PrepareStatement object
			st = connecton.createStatement();
			
			// 2.2 Set native query into Statement || PrepareStatement object & call executeQuery || executeUpdate from Statement || PrepareStatement to execute native query
			rs = st.executeQuery(sql);
			while (rs.next()) {
				// Transformer
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
			st = connecton.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				// Transformer
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
		
		// UPDATE >> INSERT, UPDATE, DELETE
		String sql = "INSERT INTO LoaiHang(MaLH, TenLH)\n"
				   + "VALUES(" + id + ", '"+ name + "')";

		try {
			// Statement >> execute complete SQL statement with full parameters
			st = connecton.createStatement();
			int affectedRows = st.executeUpdate(sql);
			
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
		String sql = "UPDATE LoaiHang \n"
				   + "	SET TenLH  = ? \n"
				   + "WHERE MaLH   = ?";
					
		try {
			// Prepare Statement >> represent a preCompile &
			pst = connecton.prepareStatement(sql);
			
			// Set parameter, complete SQL with parameter
			pst.setString(1, name);
			pst.setInt(2, id);
			
			int affectedRows = pst.executeUpdate(sql);
			result = affectedRows > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(st);
		}

		return result;
	}
	
	// Problem >>
	// 1. SQL(Statement) >> complicated in case of many parameters
	// 2. Save ==>> saveOrUpdate 

}
