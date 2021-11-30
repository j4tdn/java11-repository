package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistence.ItemGroupDto;
import utils.SqlUtils;

public class ItemGroupDaoImpl implements ItemGroupDao{

	private Connection connection;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ItemGroupDaoImpl() {
		connection = DbManager.getConnection();
	}
	
	private static String Q_GETS_ITEMS_BY_ITEM_GROUP = 
			"SELECT lh.MaLH AS " + ItemGroupDto.ID_ITEM_GROUP + ",\n"
			+ "		lh.TenLH AS " + ItemGroupDto.NAME_ITEM_GROUP + ",\n"
			+ "       SUM(ctmh.SoLuong) AS " + ItemGroupDto.NUMBER_OF_ITEMS_BY_ITEM_GROUP + " \n"
			+ "FROM loaihang lh\n"
			+ "JOIN mathang mh \n"
			+ "	ON lh.MaLH = mh.MaLH\n"
			+ "JOIN chitietmathang ctmh \n"
			+ "	ON ctmh.MaMH = mh.MaMH\n"
			+ "GROUP BY lh.MaLH;";



	@Override
	public List<ItemGroupDto> getItemsByItemGroup() {
		List<ItemGroupDto> result = new ArrayList<>();
		
		try {
			st = connection.createStatement();
			rs = st.executeQuery(Q_GETS_ITEMS_BY_ITEM_GROUP);
			while(rs.next()) {
				result.add(ItemGroupDto.addResultTransformer(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			SqlUtils.close(rs,st);
		}
		
		return result;
	}

}
