package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistence.Item;
import persistence.ItemGroup;

public class ItemDaoImpl implements ItemDao{
	private final Connection connection;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	public ItemDaoImpl() {
		connection = DbManager.getConnection();
	}
	
	@Override
	public List<Item> get(String name) {
		List<Item> result = new ArrayList<>();
		String sql = "SELECT *\n"
				   + "FROM MatHang mh\n"
				   + "Join LoaiHang lh\n"
				   + "ON mh.MaLH = lh.MaLH\n"
				   + "WHERE TenLH = ?";
//		String sql = "SELECT *\n"
//				   + "FROM MatHang mh\n"
//				   + "JOIN LoaiHang lh\n"
//				   + "ON mh.MaLH = lh.MaLH\n"
//				   + "WHERE TenLH = ?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while(rs.next()) {
				ItemGroup ig = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
				Item i = new Item(rs.getInt("MaMH"), rs.getString("TenMH"), rs.getString("MauSac"), ig);
				result.add(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
