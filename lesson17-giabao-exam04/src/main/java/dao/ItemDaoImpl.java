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
import dto.RemainingItem;
import dto.ItemWithDate;
import persistence.Item;
import persistence.ItemGroup;
import utils.DateUtils;
import utils.SqlUtils;

public class ItemDaoImpl implements ItemDao{
	private final Connection connection;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	public ItemDaoImpl() {
		connection = DbManager.getConnection();
	}
	
	private static final String Q_ITEMS_BY_DATE = "SELECT mh.MaMH " +ItemWithDate.ITEM_ID + " ,\n"
			+ "mh.TenMH " + ItemWithDate.ITEM_NAME + ", \n" 
			+ "time(dh.ThoiGianDatHang) " + ItemWithDate.SALE_TIME + "\n"
			+ "FROM MatHang mh \n"
			+ "JOIN ChiTietDonHang ctdh \n"
			+ "  ON mh.MaMH = ctdh.MaMH \n"
			+ "JOIN DonHang dh \n"
			+ "  ON dh.MaDH = ctdh.MaDH \n"
			+ "WHERE CAST(dh.ThoiGianDatHang AS DATE) = ?";
	
	private static final String Q_ITEMS_REMAINING = "SELECT lh.MaLH " + RemainingItem.ITEM_ID + ",\n"
													+ "		lh.TenLH " + RemainingItem.ITEM_NAME + ",\n"
													+ "		sum(ctmh.SoLuong)" + RemainingItem.ITEM_AMOUNT + "\n"
													+ "FROM loaihang lh\n"
													+ "JOIN mathang mh \n"
													+ "		ON mh.MaLH = lh.MaLH \n"
													+ "JOIN ChiTietMatHang ctmh \n"
													+ "		ON mh.MaMH = ctmh.MaMH \n"
													+ "GROUP BY lh.MaLH";
	
	private static final String Q_TOP_3_MOST_ITEMS = "	SELECT mh.MaMH, "
													+ "		mh.TenMH TenMH, "
													+ "		sum(ctdh.SoLuong) SL \n" 
													+ "FROM mathang mh\n" 
													+ "	JOIN chitietdonhang ctdh "
													+ " 	ON ctdh.MaMH = mh.MaMH\n" 
													+ " JOIN donhang dh \n"
													+ "		ON dh.MaDH = ctdh.MaDH\n" 
													+ " WHERE year(dh.ThoiGianDatHang) = ? \n" 
													+ "	GROUP BY mh.MaMH"
													+ "	ORDER BY SL DESC\n"
													+ "	LIMIT 3\n";
		
	
	
	public List<ItemWithDate> getItemWithDate(LocalDate orderDate) {
		List<ItemWithDate> result = new ArrayList<ItemWithDate>();
		String sql = Q_ITEMS_BY_DATE;
		try {
			pst = connection.prepareStatement(sql);
			pst.setDate(1, DateUtils.toDate(orderDate));
			rs = pst.executeQuery();
			while (rs.next()) {
				result.add(ItemWithDate.addResultTransfomer(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}
	public List<RemainingItem> getRemainingItems() {
		List<RemainingItem> result = new ArrayList<RemainingItem>();
		String sql = Q_ITEMS_REMAINING;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(RemainingItem.addResultTransfomer(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}
	public List<String> getTop3SaleItems(int year) {
		List<String> result = new ArrayList<String>();
		
		try {
			pst = connection.prepareStatement(Q_TOP_3_MOST_ITEMS);
			pst.setInt(1, year);;
			rs = pst.executeQuery();
			while (rs.next()) {
				result.add(rs.getString("TenMH"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		};
		
		return result;
	}


}