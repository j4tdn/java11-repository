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
import persistence.ItemDto;
import utils.DateUtils;
import utils.SqlUtils;

public class ItemDaoImpl implements ItemDao {

	private Connection connection;
	private PreparedStatement pst;
	private static Statement st;
	private ResultSet rs;
	
	public ItemDaoImpl() {
		connection = DbManager.getConnection();
	}
	
	@Override
	public List<ItemDto> get(LocalDate orderDate) {
		List<ItemDto> results = new ArrayList<>();
		String sql = "SELECT mh.MaMH             ,\n"
				+ "          mh.TenMh            ,\n"
				+ "          dh.ThoiGianDatHang  \n"
				+ "FROM MatHang mh          \n"
				+ "JOIN ChiTietDonHang ctdh \n"
				+ "	ON mh.MaMH = ctdh.MaMH  \n"
				+ "JOIN DonHang dh          \n"
				+ "	ON ctdh.MaDH = dh.MaDH  \n"
				+ "WHERE CAST(dh.ThoiGianDatHang AS DATE) = ? ";
		try {
			pst = connection.prepareStatement(sql);
			pst.setDate(1, DateUtils.toDate(orderDate)); 
			rs = pst.executeQuery();
			System.out.println("resultSet : " + rs.toString());
			while(rs.next()) {
				ItemDto iDto = new ItemDto(rs.getInt("MaMH"), rs.getString("TenMH"),DateUtils.toTime(rs.getTime("ThoiGianDatHang")));
				results.add(iDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return results;
	}

	
}
