package dao;

import static utils.SqlUtils.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistence.ItemGroupDto;

public class ItemGroupDaoImpl implements ItemGroupDao {

	private Connection connection;
	private Statement st;
	private ResultSet rs;

	public ItemGroupDaoImpl() {
		connection = DbManager.getConnection();
	}

	public static ItemGroupDto addResultTransfomer(ResultSet rs) throws SQLException {
		return new ItemGroupDto(rs.getInt(ItemGroupDto.ITEM_GROUP_ID), rs.getString(ItemGroupDto.ITEM_GROUP_NAME),
				rs.getLong(ItemGroupDto.NUMBER_OF_ITEMS));
	}

	@Override
	public List<ItemGroupDto> getItemGroup() {
		List<ItemGroupDto> result = new ArrayList<>();
		String sql = "SELECT DISTINCT lh.MaLH AS 		     " + ItemGroupDto.ITEM_GROUP_ID + ",\n"
				+ "		 lh.TenLH AS						 " + ItemGroupDto.ITEM_GROUP_NAME + ",\n"
				+ "       SUM(ctmh.SoLuong) AS   			 " + ItemGroupDto.NUMBER_OF_ITEMS + "\n"
				+ "FROM LoaiHang lh\n" + "JOIN MatHang mh\n  " + "	ON lh.MaLH = mh.MaLH\n"
				+ "JOIN ChiTietMatHang ctmh\n" + "	ON mh.MaMH = ctmh.MaMH\n" 
				+ "WHERE mh.MaMH\n" 
				+ "GROUP BY lh.MaLH";
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(addResultTransfomer(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, st);
		}
		return result;
	}

}
