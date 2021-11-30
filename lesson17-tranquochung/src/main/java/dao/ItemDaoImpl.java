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
import persistence.ItemGroup;
import persistence.ItemGroupAndItemDto;
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
	public List<ItemDto> getItemDto(LocalDate orderDate) {
		List<ItemDto> result = new ArrayList<>();
		String sql = "SELECT mh. MaMH, mh.TenMh, TIME(dh.ThoiGianDatHang) AS ThoiGian\n" 
					+ "FROM MatHang mh \n"
					+ "JOIN chitietdonhang ctdh\n" + "	ON ctdh.MaMH = mh.MaMH\n" 
					+ "JOIN DonHang dh \n"
					+ "	ON ctdh.MaDH = dh.MaDH\n" + "WHERE DATE(dh.ThoiGianDatHang) = ? ";
		try {
			pst = connection.prepareStatement(sql);
			pst.setDate(1, DateUtils.toDate(orderDate));
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemDto item = new ItemDto(rs.getInt("MaMH"), rs.getString("TenMH"),
						rs.getTime("ThoiGian").toLocalTime());
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
	public List<String> getItem(int year) {
		List<String> result = new ArrayList<>();
		String sql = "SELECT mh. MaMH, mh.TenMh, SUM(ctdh.SoLuong) AS SoLuong\n"
				+ "FROM MatHang mh \n"
				+ "JOIN chitietdonhang ctdh\n" + "	ON ctdh.MaMH = mh.MaMH\n" 
				+ "JOIN DonHang dh \n"
				+ "	ON ctdh.MaDH = dh.MaDH\n" + "WHERE YEAR(dh.ThoiGianDatHang) = ?\n" + "GROUP BY mh.MaMH\n"
				+ "ORDER BY SoLuong DESC\n" + "LIMIT 3";
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, year);
			;
			rs = pst.executeQuery();
			while (rs.next()) {
				result.add(rs.getString("TenMh"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}

	@Override
	public List<ItemGroupAndItemDto> getAllItembyAllItemGroup() {
		List<ItemGroupAndItemDto> result = new ArrayList<>();
		String sql = "SELECT lh.MaLH, lh.TenLH, mh.MaMH, mh.TenMH, ctmh.GiaBan, ctmh.GiaMua, ctmh.SoLuong\n"
					+ "FROM MatHang mh\n"
					+ "JOIN loaihang lh\n"
					+ "	ON mh.MaLH = lh.MaLH\n"
					+ "JOIN chitietmathang ctmh\n" 
					+ "	ON ctmh.MaMH = ctmh.MaMH\n"
					+ "GROUP BY mh.MaMH\n"
					+ "ORDER BY lh.MaLH";
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemGroup group = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
				ItemGroupAndItemDto item = new ItemGroupAndItemDto(rs.getInt("MaMH"), rs.getString("TenMH"),
						rs.getDouble("GiaBan"), rs.getDouble("GiaMua"), rs.getInt("SoLuong"), group);
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
