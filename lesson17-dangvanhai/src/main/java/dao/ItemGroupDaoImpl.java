package dao;

import java.util.List;

import connection.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import persistence.ItemGroup;
import persistence.ItemGroupDto;
import utils.SqlUtils;

public class ItemGroupDaoImpl implements ItemGroupDao {
	
	private Connection connection;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	private static String Q_GET_ALL_REMAINING_ITEMS = 
			"SELECT MatHang.*, SUM(ChiTietMatHang.SoLuong) AS SoLuong\n" + 
			"FROM MatHang JOIN ChiTietMatHang ON MatHang.MaMH = ChiTietMatHang.MaMH \n" + 
			"JOIN LoaiHang ON MatHang.MaLH = LoaiHang.MaLH \n" + 
			"GROUP BY LoaiHang.MaLH;";
	
	public ItemGroupDaoImpl() {
		connection = DBManager.getConnection();
	}
	
	@Override
	public List<ItemGroupDto> getAllemaining() {
		List<ItemGroupDto> result = new ArrayList<>();
		try {
			st = connection.createStatement();
			rs = st.executeQuery(Q_GET_ALL_REMAINING_ITEMS);
			while (rs.next()) {
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
