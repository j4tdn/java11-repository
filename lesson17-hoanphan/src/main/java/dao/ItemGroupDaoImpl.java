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
	private Connection connection;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;

	public ItemGroupDaoImpl() {
		connection = DbManager.getConnection();
	}

	private static String Q_GET_ITEMS_BY_ITEM_GROUP_ID = 
				 "SELECT lh.MaLH       "+ ItemGroupDto.ITEM_GROUP_ID +" ,\n"
			+ "   lh.TenLH			   "+ ItemGroupDto.ITEM_GROUP_NAME+",\n"
			+ "	  sum(ctmh.SoLuong)    "+ ItemGroupDto.NUMBER_OF_ITEMS+"\n"
			+ "		    from MatHang m\n"
			+ "			inner Join loaihang lh On m.maLH = lh.MaLH\n"
			+ "			inner Join chitietmathang ctmh On m.maMH = ctmh.maMH\n"
			+ "            group by m.MaLH";
	

	@Override
	public List<ItemGroupDto> getItems() {
		List<ItemGroupDto> result = new ArrayList<>();

		try {
			st = connection.createStatement();
			rs = st.executeQuery(Q_GET_ITEMS_BY_ITEM_GROUP_ID);
			while(rs.next()) {
				result.add(ItemGroupDto.addResultTransfomer(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}

		return result;
	}
	


}