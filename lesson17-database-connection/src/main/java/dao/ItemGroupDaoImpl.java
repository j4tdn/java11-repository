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
import persistence.ItemGroupDto;
import utils.SqlUtils;

public class ItemGroupDaoImpl implements ItemGroupDao{
	private Connection connection;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ItemGroupDaoImpl() {
		connection = DBManager.getConnection();
	}
	
	private static String Q_GET_ITEMS_BY_ITEM_GROUP_ID = 
					  "SELECT  lh.MaLH 			"+ ItemGroupDto.ITEM_GROUP_ID   + ",\n"
					+ "		   lh.TenLH 		"+ ItemGroupDto.ITEM_GROUP_NAME + ",\n"
	 				+ "        SUM(ctmh.SoLuong)"+ ItemGroupDto.NUMBER_OF_ITEMS +"\n"
					+ "FROM LoaiHang lh\n"
					+ "JOIN MatHang mh\n"
					+ "	 ON lh.MaLH = mh.MaLH\n"
					+ "JOIN ChiTietMatHang ctmh\n"
					+ "	 ON mh.MaMH = ctmh.MaMH\n"
					+ "GROUP BY lh.MaLH";
	
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
	public List<ItemGroup> get(String name) {
		List<ItemGroup> result = new ArrayList<>();
		String sql = "SELECT * FROM LoaiHang\n"
				+ "WHERE TenLH = ?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while(rs.next()) {
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
		
		Integer id = itemGroup.getId();
        String name = itemGroup.getName();
        
		String sql = "UPDATE LoaiHang \n" +
                "SET TenLH = ? \n" +
                "WHERE MaLH = ?";
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
		try {
			st = connection.createStatement();
			rs = st.executeQuery(Q_GET_ITEMS_BY_ITEM_GROUP_ID);
			while(rs.next()) {
				result.add(ItemGroupDto.addResultTransfomer(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}

		return result;
	}

}
