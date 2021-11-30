package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistence.DetaiItemGroupDto;

public class DetailItemGroupDaoImpl implements DetailItemGroupDao{
	private  final Connection connection;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public DetailItemGroupDaoImpl() {
		this.connection = DbManager.getConnection();;		
	}
	
	public List<DetaiItemGroupDto> get(){
		List<DetaiItemGroupDto>result = new ArrayList<DetaiItemGroupDto>();
		String sql = "select loaihang.MaLH MaLoai ,tenlh TenLoai, sum(soluong) soLuong \n"
				+ "from loaihang\n"
				+ "join mathang \n"
				+ "on mathang.MaLH=loaihang.MaLH\n"
				+ "join chitietmathang \n"
				+ "on mathang.MaMH=chitietmathang.MaMH\n"
				+ "GROUP BY loaihang.MaLH";
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				result.add(new DetaiItemGroupDto(rs.getInt("MaLoai"), rs.getString("TenLoai"), rs.getInt("soLuong")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}
