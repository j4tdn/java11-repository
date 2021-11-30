package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistence.ItemGroup;
import persistence.ItemGroupDto;
import utils.SqlUtils;

public class ItemGroupDaoImpl implements ItemGroupDao {
	private final Connection connection;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public ItemGroupDaoImpl() {
		connection = DbManager.getConnection();
	}

	@Override
	public List<ItemGroupDto> get() {
		List<ItemGroupDto> result = new ArrayList<>();
		String sql = "SELECT lh.MaLH, lh.TenLH, SUM(ctmh.SoLuong) AS SoLuong\n"
				+ "FROM LoaiHang AS lh\n"
				+ "JOIN MatHang AS mh\n"
				+ "ON lh.MaLH = mh.MaLH\n"
				+ "JOIN ChiTietMatHang AS ctmh\n"
				+ "ON ctmh.MaMH = mh.MaMH\n"
				+ "GROUP BY mh.MaLH;";
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				ItemGroupDto igDto = new ItemGroupDto(rs.getInt("MaLH"), rs.getString("TenLH"), rs.getInt("SoLuong"));
				result.add(igDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}




}
