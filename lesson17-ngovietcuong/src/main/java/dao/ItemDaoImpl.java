package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistence.ItemDto;
import persistence.ItemsDto;
import utils.DateUtils;
import utils.SqlUtils;

public class ItemDaoImpl implements ItemDao {

	private final Connection connection;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ItemDaoImpl() {
		connection = DbManager.getConnection();
	}
	
	@Override
	public List<ItemDto> get(LocalDate orderDate) {
		List<ItemDto> result = new ArrayList<>();
		String sql = "SELECT mh.MaMH, mh.TenMH, dh.ThoiGianDatHang \n"
				+ "FROM MatHang mh\n"
				+ "JOIN ChiTietDonHang ctdh\n"
				+ "  ON mh.MaMH = ctdh.MaMH\n"
				+ "JOIN DonHang dh\n"
				+ "  ON dh.MaDH = ctdh.MaDH\n"
				+ "WHERE CAST(dh.ThoiGianDatHang AS DATE) = ?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setDate(1, DateUtils.toDate(orderDate));
			rs = pst.executeQuery();
			while(rs.next()) {
				ItemDto item = new ItemDto(rs.getInt("MaMH"), rs.getString("TenMH"), rs.getString("ThoiGianDatHang"));
				result.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}
	
	@Override
	public List<String> getTopThreeItem(int year) {
		List<String> result = new ArrayList<>();
		String sql = 
				  "SELECT mh.MaMH, mh.TenMH, SUM(ctdh.SoLuong) SoLuong\n"
				+ "FROM DonHang dh\n"
				+ "JOIN ChiTietDonHang ctdh \n"
				+ "ON dh.MaDH = ctdh.MaDH\n"
				+ "JOIN MatHang mh\n"
				+ "ON ctdh.MaMH = mh.MaMH\n"
				+ "WHERE CAST(dh.ThoiGianDatHang AS YEAR) = ?\n"
				+ "GROUP BY mh.MaMH\n"
				+ "ORDER BY SoLuong DESC\n"
				+ "LIMIT 3";
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, year);
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
	
	@Override
	public List<ItemsDto> getItems() {
		List<ItemsDto> result = new ArrayList<>();
		String sql = 
				  "SELECT lh.MaLH, lh.TenLH, mh.MaMH,\n"
				  + "	   mh.TenMH, ctmh.MaKC, ctmh.GiaBan,\n"
				  + "       ctmh.GiaMua, ctmh.SoLuong \n"
				  + "FROM MatHang mh\n"
				  + "JOIN LoaiHang lh\n"
				  + "ON mh.MaLH = lh.MaLH\n"
				  + "JOIN ChiTietMatHang ctmh\n"
				  + "ON   ctmh.MaMH = mh.MaMH";
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {				
				ItemsDto item1 = new ItemsDto(rs.getInt("MaLH"), rs.getString("TenLH"), rs.getInt("MaMH"),
						rs.getString("TenMH"), rs.getString("MaKC"), rs.getInt("GiaBan"), rs.getInt("GiaMua"), rs.getInt("SoLuong"));
				result.add(item1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}
}
