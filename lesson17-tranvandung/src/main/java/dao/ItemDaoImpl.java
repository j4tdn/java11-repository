package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistence.Item;
import persistence.ItemDto;
import persistence.ItemGroup;
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
	public List<Item> get(String igName) {
		List<Item> result = new ArrayList<>();
		String sql = "SELECT * " + "FROM MatHang mh\n" + "JOIN LoaiHang lh \n" + "ON mh.MaLH = lh.MaLH\n"
				+ "WHERE lh.TenLH = ?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, igName);
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemGroup group = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
				Item item = new Item(rs.getInt("MaMH"), rs.getString("TenMH"), rs.getString("MauSac"), group);
				result.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}

	// === JDBC setParameter ===
	// setDate(java.sql.Date): d/M/Y >> sql date
	// setTime(java.sql.Time): H:m:s >> sql time
	// setTimeStamp(java.sql.TimeStamp): d/M/Y H:m:s >> sql date time

	// === JAVA UI ===
	// java.util.Date, java.util.Calendar
	// java.time.LocalDate, java.time.Localtime, java.time.LocalTime
	@Override
	public List<Item> get(LocalDate orderDate) {
		List<Item> result = new ArrayList<>();
		String sql = "SELECT DISTINCT mh.*\n" + "FROM MatHang mh\n" + "JOIN ChiTietDonHang ctdh\n"
				+ "  ON mh.MaMH = ctdh.MaMH\n" + "JOIN DonHang dh\n" + "  ON dh.MaDH = ctdh.MaDH\n"
				+ "WHERE CAST(dh.ThoiGianDatHang AS DATE) = ?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setDate(1, DateUtils.toDate(orderDate));
			rs = pst.executeQuery();
			while (rs.next()) {
				Item item = new Item(rs.getInt("MaMH"), rs.getString("TenMH"), rs.getString("MauSac"));
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
	public List<ItemDto> getItemDto(LocalDate orderDate) {
		List<ItemDto> result = new ArrayList<>();
		String sql = "SELECT mh. MaMH, mh.TenMh, TIME(dh.ThoiGianDatHang) AS ThoiGian\n" + "FROM MatHang mh \n"
				+ "JOIN chitietdonhang ctdh\n" + "	ON ctdh.MaMH = mh.MaMH\n" + "JOIN DonHang dh \n"
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
	public List<String> getTop3ItemsName(int year) {
		List<String> result = new ArrayList<>();
		String sql = "SELECT mh. MaMH, mh.TenMh, SUM(ctdh.SoLuong) AS SoLuong\n" + "FROM MatHang mh \n"
				+ "JOIN chitietdonhang ctdh\n" + "	ON ctdh.MaMH = mh.MaMH\n" + "JOIN DonHang dh \n"
				+ "	ON ctdh.MaDH = dh.MaDH\n" + "WHERE YEAR(dh.ThoiGianDatHang) = ?\n" + "GROUP BY mh.MaMH\n"
				+ "ORDER BY SoLuong DESC\n" + "LIMIT 3;";
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, year);
			rs = pst.executeQuery();
			while (rs.next()) {
				String item = rs.getString("TenMH");
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
