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

	public ItemGroupDaoImpl() {
		connection = DbManager.getConnection();
	}

	private static String Q_GET_ITEMS_BY_ITEM_GROUP_ID = "SELECT  lh.MaLH		" + ItemGroupDto.ITEM_GROUP_ID + ",\n"
			+ "		lh.TenLH		" + ItemGroupDto.ITEM_GROUP_NAME + ", \n" + "        SUM(ctmh.SoLuong)"
			+ ItemGroupDto.NUMBER_OF_ITEMS + "\n" + "FROM LoaiHang lh\n" + "JOIN MatHang mh\n"
			+ "	ON lh.MaLH = mh.MaLH\n" + "JOIN ChiTietMatHang ctmh\n" + "	ON mh.MaMH = ctmh.MaMH\n"
			+ "GROUP BY lh.MaLH";

	@Override
	public ItemGroup get(int id) {
		ItemGroup result = null;
		// 1. Write down a native query
		String sql = "Select * from loaihang\n" + "where malh= " + id;

		// 2. Execute the native query and return data
		try {
			// 2.1 Initial statement or prepareStatement
			st = connection.createStatement();
			// 2.2 Set native query into statement or prepareStatement & execute native
			// query
			rs = st.executeQuery(sql);
			if (rs.next()) {
				result = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
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
	public List<ItemGroup> get(String name) {
		List<ItemGroup> result = new ArrayList<>();
		String sql = "Select MaLH,TenLH from LoaiHang where TenLH=?";

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
	public List<ItemGroup> getAll() {
		List<ItemGroup> result = new ArrayList<>();
		// 1. Write down a native query
		String sql = "Select MaLH,TenLH from LoaiHang";

		// 2. Execute the native query and return data
		try {
			// 2.1 Initial statement or prepareStatement
			st = connection.createStatement();
			// 2.2 Set native query into statement or prepareStatement & execute native
			// query
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
	public boolean save(ItemGroup itemGroup) {
		boolean result = false;
		String sql = "insert into Loaihang(MaLH ,TenLH)\n" + "values (?,?)";

		// 2. Execute the native query and return data
		try {
			// 2.1 Initial statement or prepareStatement
			pst = connection.prepareStatement(sql);
			pst.setInt(1, itemGroup.getId());
			pst.setString(2, itemGroup.getName());
			int affectesRows = pst.executeUpdate();
			result = affectesRows > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtils.close(pst);
		}
		return result;
	}

	@Override
	public boolean update(ItemGroup itemGroup) {
		boolean result = false;
		String sql = "update loaihang \n" + " set tenlh= ? \n" + " where malh=?";

		// 2. Execute the native query and return data
		try {
			// 2.1 Initial statement or prepareStatement
			pst = connection.prepareStatement(sql);
			pst.setString(1, itemGroup.getName());
			pst.setInt(2, itemGroup.getId());
			int affectesRows = pst.executeUpdate();
			result = affectesRows > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtils.close(pst);
		}
		return result;
	}

	@Override
	public List<ItemGroupDto> getItemsByItemGroupId() {
		List<ItemGroupDto> result = new ArrayList<>();
		// 1. Write down a native query
		String sql = Q_GET_ITEMS_BY_ITEM_GROUP_ID;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
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