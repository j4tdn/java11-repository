package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import connection.DbProvider;
import persistence.ItemGroupDto;
import utils.SqlUtils;

public class ItemGroupDaoImpl implements ItemGroupDao{
	private static Connection connection;
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	
	public ItemGroupDaoImpl() {
		connection = DbManager.getConnection();
	}
	
	@Override
	public List<ItemGroupDto> getItemsByItemGroupId() {
		List<ItemGroupDto> results = new ArrayList<>();

		String sql = "SELECT  lh.MaLH, \n"
				+ "		      lh.TenLH,\n"
		        + "SUM(ctmh.SoLuong) SoLuongMatHang \n"
				+ "FROM LoaiHang lh    \n"
				+ "JOIN MatHang mh     \n"
				+ "	 ON lh.MaLH = mh.MaLH    \n"
				+ "JOIN ChiTietMatHang ctmh  \n"
				+ "	 ON mh.MaMH = ctmh.MaMH  \n"
				+ "GROUP BY lh.MaLH";
		try {
			st = connection.createStatement();

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				ItemGroupDto igDto = new ItemGroupDto(rs.getInt("MaLH"), rs.getString("TenLH"), rs.getInt("SoLuongMatHang"));
				results.add(igDto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}

		return results;
	}
	
}
