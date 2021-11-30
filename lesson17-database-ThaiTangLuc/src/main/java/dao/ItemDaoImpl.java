package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistence.Item;
import persistence.ItemDetail;
import persistence.ItemDto;
import persistence.ItemGroup;
import utils.DateUtils;

public class ItemDaoImpl implements ItemDao{
	private final Connection connection;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	public ItemDaoImpl() {
		connection = DbManager.getConnection();
	}
	
	@Override
	public List<ItemDto> getTime(LocalDate time) {
		List<ItemDto> result = new ArrayList<>();
		String sql = "SELECT mh.MaMH, mh.TenMH, dh.ThoiGianDatHang\n"
				   + "FROM MatHang mh\n"
				   + "JOIN ChiTietDonHang ctdh\n"
				   + "ON mh.MaMH = ctdh.MaMH\n"
				   + "JOIN DonHang dh\n"
				   + "ON ctdh.MaDH = dh.MaDH\n"
				   + "WHERE CAST(dh.ThoiGianDatHang AS DATE) LIKE ?";

		try {
			pst = connection.prepareStatement(sql);
			pst.setDate(1, DateUtils.toDate(time));
			rs = pst.executeQuery();
			while(rs.next()) {
				ItemDto iDto = new ItemDto(rs.getInt("MaMH"), rs.getString("TenMH"), rs.getTime("ThoiGianDatHang"));
				result.add(iDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<Item> getTopQuantity(String year) {
		List<Item> result = new ArrayList<>();
		String sql = "SELECT mh.MaMH,\n"
				   + "	   mh.TenMH\n"
				   + "FROM MatHang mh\n"
				   + "JOIN ChiTietDonHang ctdh\n"
				   + "ON mh.MaMH = ctdh.MaMH\n"
				   + "JOIN DonHang dh\n"
				   + "ON ctdh.MaDH = dh.MaDH\n"
				   + "WHERE CAST(dh.ThoiGianDatHang AS DATE) LIKE '" + year + "%'\n"
				   + "GROUP BY MaMH\n"
				   + "LIMIT 3";

		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Item item = new Item(rs.getInt("MaMH"), rs.getString("TenMH"));
				result.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<ItemDetail> get() {
		List<ItemDetail> result = new ArrayList<>();
		String sql = "SELECT lh.*, \n"
				   + "	   mh.MaMH, mh.TenMH,\n"
				   + "     ctmh.GiaBan, ctmh.GiaMua, ctmh.SoLuong\n"
				   + "FROM LoaiHang lh\n"
				   + "JOIN MatHang mh\n"
				   + "ON lh.MaLH = mh.MaLH\n"
				   + "JOIN  ChiTietMatHang ctmh\n"
				   + "ON mh.MaMH = ctmh.MaMH";

		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ItemDetail iDetail = new ItemDetail(rs.getInt("MaLH"), rs.getString("TenLH"), 
							 		 rs.getInt("MaMH"), rs.getString("TenMH"),
							 		 rs.getDouble("GiaBan"), rs.getDouble("GiaMua"), rs.getInt("SoLuong"));
				result.add(iDetail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
