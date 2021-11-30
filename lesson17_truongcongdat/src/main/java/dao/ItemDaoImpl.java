package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import connection.DBManager;
import persistence.ItemDetailGroupDto;
import persistence.ItemDto;
import utils.DateUtils;
import utils.SqlUtils;

public class ItemDaoImpl implements ItemDao{
	
	private final Connection connection;
	private PreparedStatement pst;
	private ResultSet rs;
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public ItemDaoImpl() {
		connection = DBManager.getConnection();
	}
	
	//1.
	@Override
	public List<ItemDto> get(LocalDate orderDate) {
		List<ItemDto> result = new ArrayList<>();
		String sql = "SELECT mh.*, dh.ThoiGianDatHang\n"
				   + "FROM MatHang mh\n"
				   + "JOIN ChiTietDonHang ctdh\n"
				   + "ON mh.MaMH = ctdh.MaMH\n"
				   + "JOIN DonHang dh\n"
				   + "ON dh.MaDH = ctdh.MaDH\n"
				   + "WHERE CAST(dh.ThoiGianDatHang AS DATE) = ?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setDate(1, DateUtils.toDate(orderDate));
			rs = pst.executeQuery();
			while(rs.next()) {
				ItemDto item = new ItemDto(rs.getInt("MaMH"), rs.getString("TenMH"), LocalDateTime.parse(rs.getString("ThoiGianDatHang"), formatter).toLocalTime());
				result.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}
	
	//3.
	@Override
	public List<String> getTop3(String year) {
		List<String> result = new ArrayList<>();
		String sql = "SELECT mh.TenMH, SUM(SoLuong) as SoLuong\n"
				+ "FROM chitietdonhang ctdh\n"
				+ "JOIN mathang mh\n"
				+ "ON ctdh.MaMH = mh.MaMH\n"
				+ "JOIN donhang dh\n"
				+ "ON dh.MaDH = ctdh.MaDH\n"
				+ "WHERE year(dh.ThoiGianDatHang) = ?\n"
				+ "GROUP BY mh.MaMH\n"
				+ "ORDER BY SoLuong DESC\n"
				+ "LIMIT 3";
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, year);
			rs = pst.executeQuery();
			while(rs.next()) {
				result.add(rs.getString("TenMH"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}
	
	//4
	@Override
	public List<ItemDetailGroupDto> getItemByIg() {
		List<ItemDetailGroupDto> result = new ArrayList<>();
		String sql = "SELECT *\n"
				+ "FROM mathang mh\n"
				+ "JOIN loaihang lh \n"
				+ "ON lh.MaLH = mh.MaLH\n"
				+ "JOIN chitietmathang ctmh\n"
				+ "ON ctmh.MaMH = mh.MaMH";
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				ItemDetailGroupDto item = new ItemDetailGroupDto(rs.getInt("MaLH"), 
						rs.getString("TenLH"), 
						rs.getInt("MaMH"), 
						rs.getString("TenMH") , 
						rs.getInt("GiaBan"), 
						rs.getInt("GiaMua"), 
						rs.getInt("SoLuong"));
				result.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}

}
