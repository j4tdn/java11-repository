package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistence.Item;
import persistence.ItemGroup;
import utils.DateUtils;
import utils.SqlUtils;

public class ItemDaoImpl implements ItemDao{
	
	private final Connection connection;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	public ItemDaoImpl() {
		connection = DbManager.getConnection();
	}

	@Override
	public List<Item> get(String igName) {
		List<Item> result = new ArrayList<>();
		String sql = "Select * from mathang mh join loaihang lh on mh.MaLH = lh.MaLH where lh.TenLH=?";

		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, igName);
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemGroup itemGroup = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
				Item item = new Item(rs.getInt("MaMH"), rs.getString("TenMH"), rs.getString("MauSac"), itemGroup);
				result.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}
	
	// 	=========== JDBC set Parameter ===========
	//Set Date(java.sql.Date)				 d/M/Y					>>> sql Date
	//Set Time(java.sql.Time)				H:m:s					>>> sql time
	//Set TimeStamp(java.sql.TimeStamp)		d/M/Y H:m:s 			>>> sql Datetime
	
	
	// ==============JAVA UI ==============
	//java.util.Date, java.util.Calendar
	//java.time.LocalDate, java.time.Localtime, java.time.LocalDateTime
	@Override
	public List<Item> get(LocalDate orderdate) {
		List<Item> result = new ArrayList<>();
		String sql = "SELECT DISTINCT mh.* \n"
				+ "FROM MatHang mh \n"
				+ "JOIN ChiTietDonHang ctdh \n"
				+ "  ON mh.MaMH = ctdh.MaMH \n"
				+ "JOIN DonHang dh \n"
				+ "  ON dh.MaDH = ctdh.MaDH \n"
				+ "WHERE CAST(dh.ThoiGianDatHang AS DATE) = ?";

		try {
			pst = connection.prepareStatement(sql);
			pst.setDate(1, DateUtils.toDate(orderdate));
			rs = pst.executeQuery();
			while (rs.next()) {
				Item item = new Item(rs.getInt("MaMH"), rs.getString("TenMH"), rs.getString("MauSac"));
				result.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}
}