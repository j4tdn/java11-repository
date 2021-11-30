package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connection.DbManager;
import persistence.ItemByDate;
import persistence.ItemByQuantity;

public class ItemDAO {
	private final Connection connection;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ItemDAO() {
		connection = DbManager.getConnection();
	}
	
	public  List<ItemByDate> getItemByDate(LocalDate time) {
		List<ItemByDate> result = new ArrayList<>();
 		String sql = "select m.mamh,tenmh,thoigiandathang"+
 				"from mathang m"+
 				"inner join chitietdonhang c on m.mamh = c.mamh"+
 				"inner join donhang h on c.madh = h.madh"+
 				"where cast(thoigiandathang as date) = ?" ;
 		Date timeConvert = java.sql.Date.valueOf(time);
		try {
			pst = connection.prepareStatement(sql);
			pst.setDate(1, (java.sql.Date) timeConvert);
			rs = pst.executeQuery();
			while(rs.next()) {
				ItemByDate item = new ItemByDate(rs.getString("MaMH"), rs.getString("TenMH"),rs.getDate("thoigiandathang"));
				result.add(item);
			}
			rs.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	public  List<ItemByQuantity> getItemByQuantity() {
		List<ItemByQuantity> result = new ArrayList<>();
 		String sql = "select m.mamh,tenmh,soluong"+
 				"from mathang m"+
 				"inner join chitietmathang c on m.mamh = c.mamh";
 				
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				ItemByQuantity item = new ItemByQuantity(rs.getString("MaMH"), rs.getString("TenMH"),rs.getInt("SoLuong"));
				result.add(item);
			}
			rs.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	
	
	
}
