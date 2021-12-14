package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistence.Item;
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
		String sql = "SELECT *\n"
					+ "FROM mathang mh\n"
					+ "JOIN loaihang lh\n"
					+ "   ON mh.MaLH = lh.MaLH\n"
					+ "WHERE lh.TenLH = ?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, igName);
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemGroup group = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
				Item item = new Item(rs.getInt("MaMH"), rs.getString("TenMH"), rs.getString("MauSau"), group);
				
				result.add(item);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}
	
	// === JDBC setParameter===
	// setDate(jave.sql.Date): d/M/Y                 >> sql date
	// setTime(jave.sql.Time): H:m:s 				 >> sql time
	// setTimeStamp(jave.sql.TimeStamp): d/M/Y H:m:s >> sql datetime
	// === JAVA UI ===
	// java.util.Date, java.util.Calendar
	// java.time.LocalDate, java.time.LocalTime, java.time.LocalDateTime
	@Override
	public	List<Item> get(LocalDate orderDate){
		List<Item> result = new ArrayList<>();
		String sql = "SELECT DISTINCT mh.*\n"
				+ "FROM mathang mh\n"
				+ "JOIN chitietdonhang ctdh\n"
				+ "    ON mh.MaMH = ctdh.MaMH\n"
				+ "JOIN donhang dh\n"
				+ "    ON dh.MaDH = ctdh.MaDH\n"
				+ "WHERE CAST(dh.ThoiGianDatHang AS DATE) = ?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setDate(1, DateUtils.toDate(orderDate));
			rs = pst.executeQuery();
			while (rs.next()) {
				Item item = new Item(rs.getInt("MaMH"), rs.getString("TenMH"), rs.getString("MauSau"));
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
