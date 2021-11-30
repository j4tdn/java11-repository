package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connection.DBManager;
import persistence.Item;
import persistence.ItemDetailDto;
import persistence.ItemDto;
import utils.DateUtils;
import utils.SqlUtils;

public class ItemDaoImpl implements ItemDao {
	
	private final Connection connection;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public ItemDaoImpl() {
		connection = DBManager.getConnection();
	}
	
	public List<ItemDto> get(LocalDate orderDate) {
		List<ItemDto> result = new ArrayList<>();
		String sql = "SELECT mh.*, dh.* \n" + 
				"FROM MatHang mh\n" + 
				"JOIN ChiTietDonHang ctdh\n" + 
				"  ON mh.MaMH = ctdh.MaMH\n" + 
				"JOIN DonHang dh\n" + 
				"  ON dh.MaDH = ctdh.MaDH\n" + 
				"WHERE CAST(dh.ThoiGianDatHang AS DATE) = ?";

		try {
			pst = connection.prepareStatement(sql);
			pst.setDate(1, DateUtils.toDate(orderDate));
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemDto itemDto = ItemDto.addResultTransformer(rs); 
				result.add(itemDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		
		return result;
	}

	@Override
	public List<Item> getTopHotItems(int year) {
		String sql = "SELECT mh. MaMH, mh.TenMh, mh.MauSac, SUM(ctdh.SoLuong) AS SoLuong \n" + 
				"FROM MatHang mh  \n" + 
				"JOIN chitietdonhang ctdh \n" + 
				"	ON ctdh.MaMH = mh.MaMH \n" + 
				"JOIN DonHang dh  \n" + 
				"	ON ctdh.MaDH = dh.MaDH \n" + 
				"WHERE YEAR(dh.ThoiGianDatHang) = ? \n" + 
				"GROUP BY mh.MaMH \n" + 
				"ORDER BY SoLuong DESC \n" + 
				"LIMIT 3;";
		
		List<Item> result = new ArrayList<>();
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, year);
			rs = pst.executeQuery();
			while(rs.next()) {
				Item item = new Item(rs.getInt("MaMH"), rs.getString("TenMH"), rs.getString("MauSac"));
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
	public List<ItemDetailDto> getAll() {
		String sql = "SELECT mh.MaLH, lh.TenLH, mh.MaMH, mh.TenMH, ctmh.GiaBan, ctmh.GiaMua, ctmh.SoLuong\r\n" + 
				"FROM MatHang mh\r\n" + 
				"JOIN loaihang lh\r\n" + 
				"	ON mh.MaLH = lh.MaLH\r\n" + 
				"JOIN chitietmathang ctmh\r\n" + 
				"	ON ctmh.MaMH = ctmh.MaMH\r\n" + 
				"GROUP BY mh.MaMH\r\n" + 
				"ORDER BY lh.MaLH";
		List<ItemDetailDto> result = new ArrayList<>();
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(ItemDetailDto.addResultTransfomer(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}
}
