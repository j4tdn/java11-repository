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
import utils.DateUtils;
import utils.SqlUtils;

public class ItemDaoIpml implements ItemDao {

	private final Connection connection;
	private PreparedStatement pst;
	private ResultSet rs;

	public ItemDaoIpml() {
		connection = DbManager.getConnection();
	}
	
	private static String Q_GET_ITEMS_BY_ORDERTIME = 
			  "SELECT mh.MaMH,\n"
			+ 	  	  "mh.TenMH,\n"
			+ 		  "dh.ThoiGianDatHang\n"
			+ "FROM MatHang mh\n"
			+ "JOIN ChiTietDonHang ctdh\n"
			+ "  ON mh.MaMH = ctdh.MaMH\n"
			+ "JOIN DonHang dh\n"
			+ "  ON dh.MaDH = ctdh.MaDH\n"
			+ "WHERE CAST(dh.ThoiGianDatHang AS DATE) = ?";

	@Override
	public List<ItemDto> get(LocalDate orderDate) {
		List<ItemDto> result = new ArrayList<>();
		
		try {
			pst = connection.prepareStatement(Q_GET_ITEMS_BY_ORDERTIME);
			pst.setDate(1, DateUtils.toDate(orderDate));
			rs = pst.executeQuery();
			
			while(rs.next()) {
				ItemDto itemDto = new ItemDto(rs.getInt("MaMH"), rs.getString("TenMH"), DateUtils.toTime(rs.getTime("ThoiGianDatHang")));
				result.add(itemDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			SqlUtils.close(rs, pst);
		}
		
		
		return result;
	}
}
