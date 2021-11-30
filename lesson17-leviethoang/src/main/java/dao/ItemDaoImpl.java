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

public class ItemDaoImpl implements ItemDao {
	private Connection connection;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ItemDaoImpl() {
		connection = DbManager.getConnection();
	}
	
	private static String Q_GETS_ITEMS_BY_DATE =
			"SELECT mh.MaMH AS " + ItemDto.ITEM_ID + ",\n"
			+ "	   mh.TenMH AS " + ItemDto.ITEM_NAME + ",\n"
			+ "      CAST(dh.ThoiGianDatHang AS TIME) AS  " + ItemDto.TIME_ORDER + " \n"
			+ "FROM mathang mh\n"
			+ "JOIN chitietdonhang ctdh\n"
			+ "	ON mh.MaMH = ctdh.MaMH\n"
			+ "JOIN donhang dh\n"
			+ "	ON ctdh.MaDH = dh.MaDH\n"
			+ "WHERE CAST(dh.ThoiGianDatHang AS DATE) = ? ";
	
	
	private static String Q_GETS_THREE_ITEMS_BEST_SEELING_OF_THE_YEAR = 
			"SELECT 	mh.TenMH\n"
			+ "FROM mathang mh\n"
			+ "JOIN chitietmathang ctmh \n"
			+ "	ON ctmh.MaMH = mh.MaMH\n"
			+ "JOIN loaihang lh\n"
			+ "	ON lh.MaLH = mh.MaLH\n"
			+ "JOIN ChiTietDonHang ctdh \n"
			+ "	ON ctdh.MaMH = mh.MaMH\n"
			+ "JOIN DonHang dh \n"
			+ "	ON dh.MaDH = ctdh.MaDH\n"
			+ "WHERE YEAR(dh.ThoiGianDatHang) = ? \n"
			+ "ORDER BY ctmh.SoLuong DESC\n"
			+ "LIMIT 3;";
	
	private static String Q_STATISTIC = 
			"SELECT  lh.MaLH,\n"
			+ "		lh.TenLH,\n"
			+ "        mh.MaMH,\n"
			+ "        mh.TenMH,\n"
			+ "        ctmh.GiaBan,\n"
			+ "        ctmh.GiaMua,\n"
			+ "        SUM(ctmh.SoLuong) AS SoLuong \n"
			+ "FROM LoaiHang lh \n"
			+ "JOIN MatHang mh ON mh.MaLH = lh.MaLH\n"
			+ "JOIN chitietmathang ctmh ON ctmh.MaMH = mh.MaMH\n"
			+ "GROUP BY mh.MaMH; ";
	
	
	
	@Override
	public List<ItemDto> getItemsByDate(LocalDate orderDate) {
			List<ItemDto> result = new ArrayList<>(); 
		
		try {
			pst = connection.prepareStatement(Q_GETS_ITEMS_BY_DATE);
			pst.setDate(1, DateUtils.toDate(orderDate));
			rs = pst.executeQuery();
			while(rs.next()) {
				result.add(ItemDto.addResultTransformer(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			SqlUtils.close(rs,pst);
		}
		
		return result;
	}



	@Override
	public List<String> getThreeItemBestSellingOfTheYear(int year) {
		List<String> result = new ArrayList<>();
		try {
			pst = connection.prepareStatement(Q_GETS_THREE_ITEMS_BEST_SEELING_OF_THE_YEAR);
			pst.setInt(1, year);
			rs = pst.executeQuery();
			while(rs.next()) {
				result.add(rs.getString("TenMH"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			SqlUtils.close(rs,pst);
		}
		
		
		return result;
	}



	@Override
	public List<Item> statistic() {
List<Item> result = new ArrayList<>();
		
		try {
			st = connection.createStatement();
			rs = st.executeQuery(Q_STATISTIC);
			while(rs.next()) {
				ItemGroup itemGroup = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
				Item item = new Item(rs.getInt("MaMH"),
						rs.getString("TenMH"),
						itemGroup,
						rs.getInt("GiaBan"),
						rs.getInt("GiaMua"),
						rs.getInt("SoLuong"));
				
				result.add(item);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
