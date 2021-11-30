package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistence.ItemGroup;
import persistence.ItemGroupDto;
import utils.SqlUtils;

public class ItemGroupDaoImpl implements ItemGroupDao {
	private Connection connection;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	
	private static String Q_GET_ITEMS_BY_ITEM_GROUP_ID=
			"SELECT  lh.MaLH  "+ ItemGroupDto.ITEM_GROUP_ID+" ,\n"
					+ "		 lh.TenLH  "+ ItemGroupDto.ITEM_GROUP_NAME+",\n"
					+ "		 SUM(ctmh.SoLuong) "+ ItemGroupDto.NUMBER_OF_ITEMS+"\n"
					+ "FROM LoaiHang lh\n"
					+ "JOIN MatHang mh\n"
					+ "ON lh.MaLH = mh.MaLH\n"
					+ "JOIN ChiTietMatHang ctmh\n"
					+ "ON mh.MaMH = ctmh.MaMH\n"
					+ "GROUP BY lh.MaLH";;
	
	public ItemGroupDaoImpl() {
		connection = DbManager.getConnection();
	}

	public List<ItemGroup> getAll() {
		List<ItemGroup> result = new ArrayList<>();

		// 1.Write down a native query
		String sql = "Select * from LoaiHang";

		// 2.Excute the native query and return data

		try {
			// 2.1 Initial Statement||PrepareStatement
			st = connection.createStatement();

			// 2.2 Set native query into Statement||PrepareStatement & call
			// executeQuery||executeUpdate
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Integer id = rs.getInt("MaLH");
				String name = rs.getString("TenLH");
				ItemGroup itemGroup = new ItemGroup(id, name);
				result.add(itemGroup);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}

	@Override
	public ItemGroup get(int id) {
		ItemGroup result = null;

		String sql = "Select * from LoaiHang\n" + "WHERE MaLH = " + id;
		try {

			st = connection.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				result = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}

	@Override
	public List<ItemGroup> get(String name) {
		List<ItemGroup> result = new ArrayList<>();
		String sql = "Select * from LoaiHang\n" + "WHERE TenLH = ?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemGroup itemGroup = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
				result.add(itemGroup);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}

	@Override
	public boolean save(ItemGroup itemGroup) {
		boolean result = false;

		Integer id = itemGroup.getId();
		String name = itemGroup.getName();

		String sql = "INSERT INTO LoaiHang(MaLH, TenLH)\n" + "VALUE(" + id + ", '" + name + "')";
		try {
			st = connection.createStatement();
			int affectedRow = st.executeUpdate(sql);
			result = affectedRow > 0;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			SqlUtils.close(st);
		}
		return result;
	}

	@Override
	public boolean update(ItemGroup itemGroup) {
		boolean result = false;

		Integer id = itemGroup.getId();
		String name = itemGroup.getName();

		String sql = "UPDATE LoaiHang \n" + " SET  TenLH = ? \n" + "WHERE MALH  = ?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, name);
			pst.setInt(2, id);

			int affectedRow = pst.executeUpdate();
			result = affectedRow > 0;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			SqlUtils.close(st);
		}
		return result;
	}

	@Override
	public List<ItemGroupDto> getItemsByItemGroupId() {
		List<ItemGroupDto> result = new ArrayList<>();
		try {
			st = connection.createStatement();
			rs = st.executeQuery(Q_GET_ITEMS_BY_ITEM_GROUP_ID);
			while (rs.next()) {
				result.add(ItemGroupDto.addResultTransfomer(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}
}
