package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistence.ItemGroup;
import persistence.ItemGroupAmount;
import persistence.ItemGroupMost;
import utils.SqlUtils;

public class ItemGroupDao {
	private Connection connection;
	private ResultSet rs;
	private PreparedStatement pst;
	private Statement st;
	
	public ItemGroupDao() {
		connection = DbManager.getConnection();
	}

	

	public List<ItemGroup> getItems(Date date) {
		List<ItemGroup> result = new ArrayList<>();

		
		String sql = "SELECT mh.MaMH, mh.TenMH, dh.ThoiGianDatHang " 
				+ "FROM MatHang mh " 
				+ "JOIN ChiTietDonHang ctdh "
				+ "ON mh.MaMH = ctdh.MaMH " 
				+ "JOIN DonHang dh " 
				+ "OM dh.MaDH = ctdh.MaDH "
				+ "WHERE DATE(dh.thoigiandathang) = ? ";

		try {
			pst = connection.prepareStatement(sql);
			pst.setDate(1, date);
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemGroup items = new ItemGroup(rs.getInt("MaMH"), rs.getString("TenMH"), rs.getTime("ThoiGianDatHang"));
				result.add(items);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}
	
	
	public List<ItemGroupAmount> getItemsAmount() {
		List<ItemGroupAmount> result = new ArrayList<>();
		String sql = "SELECT lh.*, \n" 
				+ "SUM(kcmh.SoLuong) SoLuong\n" 
				+ "FROM MatHang mh\n"
				+ "JOIN LoaiHang lh\n" 
				+ " ON  mh.MaLoai = lh.MaLoai\n" 
				+ "JOIN KichCoMatHang kcmh\n"
				+ " ON  mh.MaMH = kcmh.MaMH \n" 
				+ "GROUP BY MaLoai";
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				ItemGroupAmount item = new ItemGroupAmount(rs.getInt("MaLoai"),rs.getString("TenLoai"), rs.getInt("SoLuong"));
				result.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}
	
	public List<ItemGroupMost> Items() {
		List<ItemGroupMost> result = new ArrayList<>();
		String sql = "SELECT lh.MaLoai, lh.TenLoai, mh.MaMH, mh.TenMH, mh.GiaBan, mh.GiaMua, kcmh.SoLuong \n"
					+ "FROM LoaiHang lh JOIN MatHang mh ON mh.MaLoai = lh.MaLoai \n"
					+ "JOIN KichCoMatHang kcmh ON mh.MaMH = kcmh.MaMH \n";
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				ItemGroupMost a = new ItemGroupMost(rs.getInt("MaLoai"), rs.getString("TenLoai"), rs.getInt("MaMH"), rs.getString("TenMH"), rs.getInt("GiaBan"), rs.getInt("GiaMua"), rs.getInt("SoLuong"));
				result.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}
}
