package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistence.Item;
import persistence.ItemDto;
import persistence.ItemGroup;
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
	public List<ItemDto> getItemsByDate(LocalDate orderDate) {
		List<ItemDto> result = new ArrayList<>();
		String sql = "SELECT mh.MaMH, mh.TenMH, dh.ThoiGianDatHang\n"
				+ "FROM MatHang mh\n"
				+ "JOIN ChiTietDonHang ctdh\n"
				+ "  ON mh.MaMH = ctdh.MaMH\n"
				+ "JOIN DonHang dh\n"
				+ "  ON dh.MaDH = ctdh.MaDH\n"
				+ "WHERE CAST(dh.ThoiGianDatHang AS DATE) = ?";
		
		try {
			pst = connection.prepareStatement(sql);
			pst.setDate(1, DateUtils.toDate(orderDate));
			rs = pst.executeQuery();
			while(rs.next()) {
				ItemDto item = new ItemDto(rs.getInt("MaMH"),rs.getString("TenMH"),rs.getTime("ThoiGianDatHang"));
				result.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}
	
	@Override
	public List<Item> getItemsBestSeller(String year) {
		List<Item> result = new ArrayList<>();
		String sql = "select m.MaMH, m.tenMH, sum(n.SoLuong) as SoLuong from MatHang m \n"
				+ "			Join loaihang p On m.MaLH = p.MaLH\n"
				+ "			Join chitietdonhang n On m.maMH = n.maMH\n"
				+ "            join donhang d On n.MaDH = d.MaDH\n"
				+ "            where thoigiandathang = \"?%\"\n"
				+ "            group by d.MaDH;";
		
		try {
			pst = connection.prepareStatement(sql);
			System.out.println(sql);
			pst.setString(1,year);
			rs = pst.executeQuery();
			while(rs.next()) {
				Item item = new Item(rs.getString("TenMH"));
				result.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}
	
	@Override
	public List<Item> getAll() {
		List<Item> result = new ArrayList<>();
		String sql = "select p.MaLH, p.TenLH, m.MaMH, TenMH, GiaBan, GiaMua, n.SoLuong from MatHang m \n"
				+ "			Join loaihang p On m.maLH = p.MaLH\n"
				+ "			Join chitietmathang n On m.maMH = n.maMH";
		
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				ItemGroup group = new ItemGroup(rs.getInt("MaLH"),rs.getString("TenLH"));
				Item item = new Item(rs.getInt("MaMH"),rs.getString("TenMH"), group);
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
