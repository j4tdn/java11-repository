package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistencce.Item;
import persistencce.ItemDto;
import utils.DateUtils;
import utils.SqlUtils;

public class ItemDaoImpl implements ItemDao {

	private Connection connection;
	private PreparedStatement pst;
	private ResultSet rs;
	
	
	public ItemDaoImpl() {
    connection = DbManager.getConnection();  
	}

	@Override
	public List<Item> get(LocalDate orderDate) {
		List<Item> result = new ArrayList<>();
		String sql = "SELECT mh.MaMH AS " + ItemDto.ITEM_ID + ",\n"
				+ "	   mh.TenMH AS " + ItemDto.ITEM_NAME + ",\n"
				+ "      CAST(dh.ThoiGianDatHang AS TIME) AS  " + ItemDto.TIME_ORDER + " \n"
				+ "FROM mathang mh\n"
				+ "JOIN chitietdonhang ctdh\n"
				+ "	ON mh.MaMH = ctdh.MaMH\n"
				+ "JOIN donhang dh\n"
				+ "	ON ctdh.MaDH = dh.MaDH\n"
				+ "WHERE CAST(dh.ThoiGianDatHang AS DATE) = ? ";
		
		try {
			pst = connection.prepareStatement(sql);
			pst.setDate(1, DateUtils.toDate(orderDate));
			rs = pst.executeQuery();
			while (rs.next()) {
				Item item = new Item(rs.getInt("MaLH"), rs.getString("TenMH"));
				result.add(item);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs,pst);
		}
		return result;
	}
public List<Item> get(String igName) {
		
		List<Item> result = new ArrayList<>();
		String sql = "SELECT lh.MaLH"
		        + "lh.TenLH"
		        + "SUM(ctmh.SoLuong) SoLuongMatHang"
		        + "FROM loaihang lh"
		        + "JOIN MatHang mh"
		        + "ON lh.MaLH = mh.MaLH"
		        + "JOIN ChiTietMatHang ctmh"
		        + "ON mh.MaMH = ctmh.MaMH"
		        + "GROUP BY lh.MaLH";

		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, igName);
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemGroup groups = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
				Item item = new Item(rs.getInt("MaLH"), rs.getString("TenMH"));
				result.add(item);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs,pst);
		}
		return result;
	}
public List<Item> getAll(String igName) {
	
	List<Item> result = new ArrayList<>();
	String sql = "SELECT * FROM MatHang mh"
			 + "JOIN LoaiHang lh"
			+ "ON mh.MaLH = lh.MaLH";

	try {
		pst = connection.prepareStatement(sql);
		pst.setString(1, igName);
		rs = pst.executeQuery();
		while (rs.next()) {
			ItemGroup group = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
			Item item = new Item(rs.getInt("MaLH"), rs.getString("TenMH"));
			result.add(item);
			
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		SqlUtils.close(rs,pst);
	}
	return result;
}

}
