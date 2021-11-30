package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DBManager;
import persistence.ItemGroupDto;
import persistence.ItemsDto;

public class ItemGroupDaoImpl implements ItemGroupDao {
	
	private final Connection connection;
	private Statement st;
	private ResultSet rs;
	
	public ItemGroupDaoImpl() {
		connection = DBManager.getConnection();
	}

	@Override
	public List<ItemGroupDto> getAmountItemGroup() {
		List<ItemGroupDto> result = new ArrayList<>();
		String sql = "SELECT loaihang.*,\n"
				+ "SUM(chitietmathang.SoLuong) AS SoLuong \n"
				+ "FROM loaihang\n"
				+ "LEFT JOIN mathang\n"
				+ "ON loaihang.MaLH = mathang.MaLH\n"
				+ "LEFT JOIN chitietmathang\n"
				+ "ON mathang.MaMH = chitietmathang.MaMH\n"
				+ "GROUP BY loaihang.MaLH;";
		
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ItemGroupDto itemDto = new ItemGroupDto(rs.getInt("MaLH"),
						rs.getString("TenLH"),
						rs.getInt("SoLuong"));
				
				result.add(itemDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ItemsDto> getAllItemById() {
		List<ItemsDto> result = new ArrayList<>();
		String sql = "SELECT * FROM loaihang\n"
				+ "LEFT JOIN mathang\n"
				+ "ON loaihang.MaLH = mathang.MaLH\n"
				+ "LEFT JOIN chitietmathang\n"
				+ "ON mathang.MaMH = chitietmathang.MaMH\n"
				+ "LEFT JOIN kichco\n"
				+ "ON chitietmathang.MaKC = kichco.MaKC;";
		
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				ItemsDto itemsGroups = new ItemsDto(rs.getInt("MaLH"),
						rs.getString("TenLH"),
						rs.getString("MaMH"),
						rs.getString("TenMH"),
						rs.getDouble("GiaBan"),
						rs.getDouble("GiaMua"),
						rs.getInt("SoLuong"),
						rs.getString("MaKC"));
				
				result.add(itemsGroups);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
