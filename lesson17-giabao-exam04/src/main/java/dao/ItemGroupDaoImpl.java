package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import dto.DetailsItems;
import dto.RemainingItem;
import persistence.ItemGroup;
import utils.SqlUtils;

public class ItemGroupDaoImpl implements ItemGroupDao{
	
	
	private final Connection connection;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	public ItemGroupDaoImpl() {
		connection = DbManager.getConnection();
	}
	
	private static String Q_Items = "SELECT lh.MaLH " + DetailsItems.ITEMGroup_ID + " ,\n"
									+ "		lh.TenLH " + DetailsItems.ITEMgroup_NAME + ",\n"
									+ "		mh.MaMH " + DetailsItems.ITEM_ID + ",\n"
									+ "		mh.TenMH " + DetailsItems.ITEM_NAME  + ",\n"
									+ "		ctmh.GiaBan " + DetailsItems.SALE_PRICE + ",\n"
									+ "		ctmh.GiaMua " + DetailsItems.SALE_PURCHASE + ",\n"
									+ " 	ctmh.SoLuong " + DetailsItems.AMOUNT + "\n"
									+ "FROM mathang mh \n"
									+ "JOIN loaihang lh \n"
									+ " 	ON mh.MaLH=lh.MaLH \n"
									+ "JOIN chitietmathang ctmh \n"
									+ "		ON mh.MaMH=ctmh.MaMH \n";

	public List<DetailsItems> getItemsByItemGroup() {
		List<DetailsItems> result = new ArrayList<DetailsItems>();
		String sql = Q_Items;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(DetailsItems.addResultTransfomer(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}


}
