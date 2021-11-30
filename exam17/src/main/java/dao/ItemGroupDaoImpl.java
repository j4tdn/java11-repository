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
import utils.sqlUtils;

public class ItemGroupDaoImpl implements ItemGroupDao {
	private Connection con;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public ItemGroupDaoImpl() {
		con = DbManager.getConnection();
	}

	@Override
	public List<ItemGroup> getAll() {
		String sql = "select * from loaihang";
		List<ItemGroup> list = new ArrayList<>();
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new ItemGroup(rs.getInt(1), rs.getString(2)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlUtils.close(rs, pst);
		}

		return list;
	}

	@Override
	public ItemGroup get(int id) {
		String sql = "select * from loaihang where malh = ?";
		ItemGroup item = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				item = new ItemGroup(rs.getInt(1), rs.getString(2));
			}
			pst.addBatch();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlUtils.close(rs, pst);
		}

		return item;
	}

	public boolean save(ItemGroup group) {
		String sql = "insert into loaihang(malh,tenlh) values(?,?)";
		boolean isSaved = false;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, group.getId());
			pst.setString(2, group.getName());
			isSaved = pst.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlUtils.close(pst);
		}
		return isSaved;
	}

	@Override
	public boolean update(ItemGroup itemGroup) {
		String sql = "update loaihang set tenlh =? where malh =?";
		boolean isSaved = false;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, itemGroup.getName());
			pst.setInt(2, itemGroup.getId());
			isSaved = pst.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlUtils.close(pst);
		}
		return isSaved;
	}

	@Override
	public List<ItemGroup> get(String name) {
		String sql = "select * from loaihang where tenlh = ?";
		List<ItemGroup> list = new ArrayList<>();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new ItemGroup(rs.getInt(1), rs.getString(2)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlUtils.close(rs, pst);
		}

		return list;
	}

	@Override
	public List<ItemGroupDto> getItemByItemGroups() {
		List<ItemGroupDto> list = new ArrayList<>();
		String sql = "select  l.malh as ma,l.tenlh as ten,sum(ct.soluong) as soluong from mathang as m inner join loaihang as l on m.malh = l.malh inner join chitietmathang as ct on m.mamh = ct.mamh group by l.malh";
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(ItemGroupDto.transformer(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlUtils.close(rs, pst);
		}

		return list;
	}

}
