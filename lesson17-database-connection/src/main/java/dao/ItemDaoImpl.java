package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connection.DBManager;
import persistence.Item;
import persistence.ItemGroup;
import utils.DateUtils;
import utils.SqlUtils;

public class ItemDaoImpl implements ItemDao {

	private final Connection connection;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public ItemDaoImpl() {
		connection = DBManager.getConnection();
	}

	@Override
	public List<Item> get(String igName) {
		List<Item> result = new ArrayList<>();
		String sql = "SELECT * FROM MatHang mh \r\n" + "	JOIN LoaiHang lh ON mh.MaLH = lh.MaLH \r\n"
				+ "    WHERE lh.TenLH = ?";

		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, igName);
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemGroup group = new ItemGroup(
						rs.getInt("MaLH"),
						rs.getString("TenLH"));
				Item item = new Item(
						rs.getInt("MaMH"),
						rs.getString("TenMH"),
						rs.getString("MauSac"),
						group);
				result.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}

		return result;
	}

	
	// === JDBC setParametter
	// setDate(java.sql.Date): d/M/Y	>> sql date
	// setTime(java.sql.Time): H:m:s	>> sql time
	// setTimestamp(java.sql.Timestamp): d/M/Y H:m:s	>> sql datetime
	// === JAVA ===
	// java.util.Date, java.util.Date
	
	@Override
	public List<Item> get(LocalDate orderDate) {
		List<Item> result = new ArrayList<>();
		String sql = "SELECT mh.*\n" + 
				"FROM MatHang mh\n" + 
				"JOIN ChiTietDonHang ctdh\n" + 
				"  ON mh.MaMH = ctdh.MaMH\n" + 
				"JOIN DonHang dh\n" + 
				"  ON dh.MaDH = ctdh.MaDH\n" + 
				"WHERE CAST(dh.ThoiGianDatHang AS DATE) = ?";

		try {
			pst = connection.prepareStatement(sql);
			pst.setDate(1, DateUtils.toDate(orderDate));
			rs = pst.executeQuery();
			while (rs.next()) {
				Item item = new Item(
						rs.getInt("MaMH"),
						rs.getString("TenMH"),
						rs.getString("MauSac"));
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
