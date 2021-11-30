package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistence.ItemGroupDto;
import utils.SqlUtils;

public class ItemGroupDaoImpl implements ItemGroupDao {
	
	private Connection connecton;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ItemGroupDaoImpl() {
		connecton = DbManager.getConnection();
	}
	
	private static String Q_GET_ITEMS_BY_ITEM_GROUP_ID = 
			  "SELECT  lh.MaLH " + ItemGroupDto.ITEM_GROUP_ID + ", \n"
			+ "		   lh.TenLH " + ItemGroupDto.ITEM_GROUP_NAME + ", \n"
			+ "        SUM(ctmh.SoLuong) " + ItemGroupDto.NUMBER_OF_ITEMS + " \n"
			+ "FROM LoaiHang lh\n"
			+ "JOIN MatHang mh\n"
			+ "	ON lh.MaLH = mh.MaLH\n"
			+ "JOIN ChiTietMatHang ctmh\n"
			+ "	ON mh.MaMH = ctmh.MaMH\n"
			+ "GROUP BY lh.MaLH";
	
	@Override
	public List<ItemGroupDto> getItemsByItemGroupId() {
		List<ItemGroupDto> result = new ArrayList<>();
		try {
			pst = connecton.prepareStatement(Q_GET_ITEMS_BY_ITEM_GROUP_ID);
			rs = pst.executeQuery();
			while (rs.next()) {
				try {
					result.add(ItemGroupDto.addResultTransfomer(rs));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}
}
