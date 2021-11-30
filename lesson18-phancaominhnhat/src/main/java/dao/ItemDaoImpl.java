package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connection.DBManager;
import persistence.ItemDto;
import utils.DateUtils;

public class ItemDaoImpl implements ItemDao{
	private final Connection connection;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;
	
	public ItemDaoImpl() {
		connection = DBManager.getConnection();
	}

	@Override
	public List<ItemDto> getItemSoldByDay(LocalDate orderDay) {
		List<ItemDto> result = new ArrayList<>();
		String sql = "SELECT mathang.MaMH,\n"
				+ " mathang.TenMH,\n"
				+ " donhang.ThoiGianDatHang\n"
				+ " FROM mathang\n"
				+ " LEFT JOIN chitietdonhang\n"
				+ "		ON mathang.MaMH = chitietdonhang.MaMH\n"
				+ " LEFT JOIN donhang\n"
				+ "		ON chitietdonhang.MaDH = donhang.MaDH\n"
				+ "	WHERE CAST(thoigiandathang AS DATE) = ?";
		
		try {
			pst = connection.prepareStatement(sql);
			pst.setDate(1, DateUtils.toDate(orderDay));
			rs = pst.executeQuery();
			
			while(rs.next()) {
				ItemDto itemDto = new ItemDto(rs.getInt("MaMH"),
						rs.getString("TenMH"),
						rs.getTime("ThoiGianDatHang"));
				
				result.add(itemDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<String> getItemBestSold(int year) {
		List<String> result = new ArrayList<>();
		String sql = "SELECT mathang.MaMH,\n"
				+ " mathang.TenMH,\n"
				+ " SUM(chitietdonhang.SoLuong) AS SoLuong FROM mathang\n"
				+ "LEFT JOIN chitietdonhang\n"
				+ "ON mathang.MaMH = chitietdonhang.MaMH\n"
				+ "LEFT JOIN donhang\n"
				+ "ON chitietdonhang.MaDH = donhang.MaDH\n"
				+ "WHERE donhang.ThoiGianDatHang LIKE '%"+ year +"%' \n"
				+ "GROUP BY mathang.MaMH\n"
				+ "ORDER BY SoLuong DESC\n"
				+ "LIMIT 3;";
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				String nameItem = rs.getString("TenMH");
				
				result.add(nameItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
