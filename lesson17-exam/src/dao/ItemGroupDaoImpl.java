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
import persistence.ItemGroup;
import persistence.ItemGroupDto;
import utils.SqlUtils;

public class ItemGroupDaoImpl implements ItemGroupDao{
	private final Connection connection;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ItemGroupDaoImpl() {
		connection = DbManager.getConnection();
	}

	@Override
	public List<ItemGroupDto> get(LocalDate orderDate) {
		List<ItemGroupDto> result = new ArrayList<>();
 		String sql = "SELECT *\n"
				   + "FROM chitietmathang c\n"
				   + "INNER JOIN  mathang mh on c.mamh = m.mamh\n"
				   + "WHERE cast(thoigiandathang as date) = ?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, orderDate.toString());
			rs = pst.executeQuery();
			while(rs.next()) {
				result.add(ItemGroupDto.addResultOrderByDate(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}
	
	@Override
	public List<ItemGroup> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ItemGroup get(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ItemGroup> get(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean save(ItemGroup itemGroup) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean update(ItemGroup itemGroup) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<ItemGroupDto> getItemsByItemGroupId() {
		List<ItemGroupDto> result = new ArrayList<>();
 		String sql = "select loaihang.MaLH MaLoai ,tenlh TenLoai, sum(soluong) soLuong \\n\"\r\n"
 				+ "	from loaihang\r\n"
 				+ "	join mathang \r\n"
 				+ "on mathang.MaLH=loaihang.MaLH\r\n"
 				+ "join chitietmathang \r\n"
 				+ "on mathang.MaMH=chitietmathang.MaMH\r\n"
 				+ "GROUP BY loaihang.MaLH";
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				result.add(ItemGroupDto.addResultTransfomer(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}

	

}
