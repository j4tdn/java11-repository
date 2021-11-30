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
	public 	List<Item> get(LocalDate orderDate) {
		 	List<Item> result = new ArrayList<>();
		 	String sql =
		 			"SELECT DISTINCT mh.MaMH, \n"
		 			+ "                mh.TenMH,\n"
		 			+ "                CAST(dh.ThoiGianDatHang AS TIME) ThoiGianDatHang\n"
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
					Item item = new Item(rs.getInt("MaMH"), rs.getString("TenMH"), rs.getString("ThoiGianDatHang"));
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
