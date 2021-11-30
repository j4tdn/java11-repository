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
	
	private static String Q_Items = "";

	public List<DetailsItems> getItemsByItemGroup() {
		List<DetailsItems> result = new ArrayList<DetailsItems>();
		String sql = "";
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
