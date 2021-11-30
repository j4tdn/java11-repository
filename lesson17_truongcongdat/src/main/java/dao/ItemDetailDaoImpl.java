package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DBManager;
import persistence.ItemDetailDto;
import utils.SqlUtils;

public class ItemDetailDaoImpl implements ItemDetailDao{
	private final Connection connection;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ItemDetailDaoImpl() {
		connection = DBManager.getConnection();
	}
	
	//2
	@Override
	public List<ItemDetailDto> getInventory() {
		List<ItemDetailDto> result = new ArrayList<>();
		String sql = "SELECT lh.MaLH, lh.TenLH, SUM(SoLuong) AS SoLuong\n"
				+ "FROM chitietmathang ctmh\n"
				+ "JOIN mathang mh\n"
				+ "ON ctmh.MaMH = mh.MaMH\n"
				+ "JOIN loaihang lh\n"
				+ "ON mh.MaLH = lh.MaLH\n"
				+ "GROUP BY TenLH";
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				ItemDetailDto item = new ItemDetailDto(rs.getInt("MaLH"), rs.getString("TenLH"), rs.getInt("SoLuong"));
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
