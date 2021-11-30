package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistence.Item;
import persistence.ItemGroup;
import persistence.ItemGroupDto;
import utils.DateUtils;
import utils.SqlUtils;

public class ItemDaoImpl implements ItemDao{
	
	private final Connection connection;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ItemDaoImpl() {
		connection = DbManager.getConnection();
	}

	@Override
	public List<Item> get(String igName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> get(LocalDate orderDate) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<ItemGroupDto> getItemGroupDto(LocalDate orderDate) {
		List<ItemGroupDto> result = new ArrayList<>();
		String sql = "SELECT mh. MaMH, mh.TenMh, TIME(dh.ThoiGianDatHang) AS ThoiGian\n"
					+ "FROM MatHang mh \n"
					+ "JOIN chitietdonhang ctdh\n"
					+ "	ON ctdh.MaMH = mh.MaMH\n"
					+ "JOIN DonHang dh \n"
					+ "	ON ctdh.MaDH = dh.MaDH\n"
					+ "WHERE DATE(dh.ThoiGianDatHang) = ? ";
		try {
			pst = connection.prepareStatement(sql);
			pst.setDate(1, DateUtils.toDate(orderDate));
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemGroupDto item = new ItemGroupDto(rs.getInt("MaMH"), rs.getString("TenMH"), rs.getTime("ThoiGian").toLocalTime());
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