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
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ItemGroupDaoImpl() {
		connection = DBManager.getConnection();
	}
	
	@Override
	public List<ItemGroup> getAll() {
		List<ItemGroup> result = new ArrayList<>();
		//1. Write down a native query
		String sql = "Select * From LoaiHang";
		//2. Execute the native query and return data
		
		try {
			//2.1 Initial Statement || PrepareStatement object
			st = connection.createStatement();
			
			//2.2 Set native query into Statement || PrepareStatement & execute native query
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				//Transformer
				ItemGroup item = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
				result.add(item);
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
		String sql = "Select * From LoaiHang\n"
				+ "Where MaLH = " + id;
		
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				//Transformer
				result = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));;
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
		String sql = "INSERT INTO LoaiHang(MaLH, TenLH)\n"
				+ "VALUES(" + itemGroup.getId() + ", '" + itemGroup.getName() + "')";
		try {
			st = connection.createStatement();
			result = st.executeUpdate(sql) > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}

	@Override
	public boolean update(ItemGroup itemGroup) {
		boolean result = false;
		String sql = "UPDATE LoaiHang \n"
				+ "SET TenLH = ? \n"
				+ "WHERE MaLH = ? ";
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, itemGroup.getName());
			pst.setInt(2, itemGroup.getId());
			result = pst.executeUpdate(sql) > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(st);
		}
		return result;
	}

}
