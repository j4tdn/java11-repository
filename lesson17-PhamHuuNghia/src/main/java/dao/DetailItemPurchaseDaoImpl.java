package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistence.DetaiItemGroupDto;
import persistence.DetailItemPurchaseDto;

public class DetailItemPurchaseDaoImpl implements DetailItemPurchaseDao {
	private final Connection connection;
	private PreparedStatement pst;
	private ResultSet rs;

	public DetailItemPurchaseDaoImpl() {
		this.connection = DbManager.getConnection();
	}

	@Override
	public List<DetailItemPurchaseDto> get(int year) {
		List<DetailItemPurchaseDto> result = new ArrayList<DetailItemPurchaseDto>();
		String sql = "select mathang.MaMH MaMH, mathang.TenMH TenMH, sum(SoLuong) SoLuong \n"
				+ "from mathang\n"
				+ "join chitietdonhang \n"
				+ "on mathang.MaMH = chitietdonhang.MaMH\n"
				+ "join donhang\n"
				+ "on chitietdonhang.MaDH = donhang.MaDH\n"
				+ "where year(thoigiandathang) = ?\n"
				+ "GROUP BY donhang.MaDH;"
				+ "Limit 5"
				;
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, year);
			rs = pst.executeQuery();
			while (rs.next()) {
				result.add(new DetailItemPurchaseDto(rs.getInt("MaMH"), rs.getString("TenMH"), rs.getInt("SoLuong")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
