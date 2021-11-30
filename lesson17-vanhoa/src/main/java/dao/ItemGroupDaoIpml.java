package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistence.ItemGroupDto;
import utils.SqlUtils;

public class ItemGroupDaoIpml implements ItemGroupDao {
	private final Connection connection;
	private Statement st;
	private ResultSet rs;

	public ItemGroupDaoIpml() {
		connection = DbManager.getConnection();
	}

	private static String Q_GET_ITEMS_BY_ITEM_GROUP_ID = 
			  "SELECT  lh.MaLH, \n"
			+ "		   lh.TenLH,\n"
			+ "        SUM(ctmh.SoLuong) SoLuongMatHang\n"
			+ "FROM LoaiHang lh\n" 
			+ "JOIN MatHang mh\n" 
			+ "	ON lh.MaLH = mh.MaLH\n" 
			+ "JOIN ChiTietMatHang ctmh\n"
			+ "	ON mh.MaMH = ctmh.MaMH\n" 
			+ "GROUP BY lh.MaLH";

	@Override
	public List<ItemGroupDto> getWithNumberOf() {
		List<ItemGroupDto> result = new ArrayList<>();
		try {
			st = connection.createStatement();
			rs = st.executeQuery(Q_GET_ITEMS_BY_ITEM_GROUP_ID);

			while (rs.next()) {
				ItemGroupDto igDto = new ItemGroupDto(rs.getInt("MaLH"),rs.getString("TenLH"), rs.getInt("SoLuongMatHang"));
				result.add(igDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}

		return result;
	}
}
