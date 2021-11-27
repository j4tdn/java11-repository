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
	
	private Connection connecton;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ItemGroupDaoImpl() {
		connecton = DbManager.getConnection();
	}
	
	private static String Q_GET_ITEMS_BY_ITEM_GROUP_ID = 
			  "SELECT  lh.MaLH " + ItemGroupDto.ITEM_GROUP_ID + ", \n"
			+ "		   lh.TenLH " + ItemGroupDto.ITEM_GROUP_NAME + ", \n"
			+ "        SUM(ctmh.SoLuong) " + ItemGroupDto.NUMBER_OF_ITEMS + " \n"
			+ "FROM LoaiHang lh\n"
			+ "JOIN MatHang mh\n"
			+ "	ON lh.MaLH = mh.MaLH\n"
			+ "JOIN ChiTietMatHang ctmh\n"
			+ "	ON mh.MaMH = ctmh.MaMH\n"
			+ "GROUP BY lh.MaLH";
	
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
	public List<ItemGroup> get(String name) {
		List<ItemGroup> result = new ArrayList<>();
		// SQL Injection
		String sql = "SELECT * FROM LoaiHang \n"
				   + "WHERE TenLH = ?";
		try {
			pst = connecton.prepareStatement(sql);
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
		String sql = "INSERT INTO LoaiHang(MaLH, TenLH)\n"
				   + "VALUES(" + id + ", '"+ name + "')";

		try {
			// Statement >> execute complete SQL statement with full parameters
			st = connecton.createStatement();
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
		String sql = "UPDATE LoaiHang \n"
				   + "	SET TenLH  = ? \n"
				   + "WHERE MaLH   = ? ";
					
		try {
			// Prepare Statement >> represent a preCompile &
			pst = connecton.prepareStatement(sql);
			
			// Set parameter, complete SQL with parameter
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
	public boolean saveOrUpdate(ItemGroup itemGroup) {
		return get(itemGroup.getId()) == null ? save(itemGroup) : update(itemGroup);
	}
	
	// Problem >>
	// 1. SQL(Statement) >> complicated in case of many parameters
	// 2. Save ==>> saveOrUpdate 
	
	@Override
	public List<ItemGroupDto> getItemsByItemGroupId() {
		List<ItemGroupDto> result = new ArrayList<>();
		try {
			st = connecton.createStatement();
			rs = st.executeQuery(Q_GET_ITEMS_BY_ITEM_GROUP_ID);
			while (rs.next()) {
				try {
					result.add(ItemGroupDto.addResultTransfomer(rs));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}
}
