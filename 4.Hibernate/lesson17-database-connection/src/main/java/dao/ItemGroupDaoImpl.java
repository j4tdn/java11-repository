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
import utils.SqlUtils;

public class ItemGroupDaoImpl implements ItemGroupDao {
	private Connection connection;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;

	public ItemGroupDaoImpl() {
		connection = DbManager.getConnection();
	}

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
	public List<ItemGroup> getAll() {
		List<ItemGroup> result = new ArrayList<>();
		// 1. Write down a native query
		String sql = "Select * from LoaiHang";

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
		boolean result=false;
		String sql = "insert into Loaihang(MaLH ,TenLH)\n" + "values (?,?)";

		// 2. Execute the native query and return data
		try {
			// 2.1 Initial statement or prepareStatement
			pst = connection.prepareStatement(sql);
			pst.setInt(1, itemGroup.getId());
			pst.setString(2, itemGroup.getName());
			int affectesRows= pst.executeUpdate();
			result = affectesRows>0;

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
		boolean result=false;
		String sql = "update loaihang \n"
					+" set tenlh= ? \n"
					+" where malh=?";

		// 2. Execute the native query and return data
		try {
			// 2.1 Initial statement or prepareStatement
			pst = connection.prepareStatement(sql);
			pst.setString(1, itemGroup.getName());
			pst.setInt(2, itemGroup.getId());
			int affectesRows= pst.executeUpdate();
			result = affectesRows>0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtils.close(pst);
		}
		return result;
	}


}