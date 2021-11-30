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
import persistence.ItemAndItemGroupDto;
import persistence.ItemDto;
import persistence.ItemGroup;
import utils.DateUtils;
import utils.sqlUtils;

public class ItemDaoImpl implements ItemDao {

	private final Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	public ItemDaoImpl() {
		con = DbManager.getConnection();
	}

	@Override
	public List<ItemDto> get(LocalDate orderDate) {
		List<ItemDto> list = new ArrayList<>();
		String sql = "select m.mamh as ma,m.tenmh as ten,cast(dh.thoigiandathang as date) as thoigian  from mathang as m inner join chitietdonhang as cd on m.mamh = cd.mamh inner join donhang as dh on dh.madh = cd.madh where cast(dh.thoigiandathang as date)  = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setDate(1, DateUtils.toSqlDate(orderDate));
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new ItemDto(rs.getInt(1), rs.getString(2), rs.getDate(3)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlUtils.close(rs, pst);
		}

		return list;
	}

	private static String TopItem_SQL = "with TMP_SoLuong as(\n"
			+ "select  m.mamh,m.tenmh,sum(ct.soluong) as soluong from mathang as m inner join chitietdonhang as ct on m.mamh = ct.mamh inner join chitiettinhtrangdonhang as dh on ct.madh=dh.madh where year(dh.thoigian) = ? group by m.tenmh\n"
			+ ")\n"
			+ "select  m.tenmh from mathang as m inner join TMP_SoLuong as s on m.mamh = s.mamh order by s.soluong desc limit 3";

	@Override
	public List<String> getTopOfYear(int year) {
		List<String> list = new ArrayList<>();
		try {
			pst = con.prepareStatement(TopItem_SQL);
			pst.setInt(1, year);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlUtils.close(rs, pst);
		}

		return list;
	}

	@Override
	public List<ItemAndItemGroupDto> getAllItemAndItemGroup() {
		List<ItemAndItemGroupDto> list = new ArrayList<>();
		String sql = "select l.malh as malh ,tenlh as tenlh,m.mamh as mamh,tenmh as tenmh ,giaban,giamua,soluong from mathang as m inner join loaihang as l on m.malh=l.malh inner join chitietmathang as ct on ct.mamh=m.mamh";
		try {
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(ItemAndItemGroupDto.transformer(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlUtils.close(rs, pst);
		}

		return list;
	}

}
