package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistence.DetaiItemDto;
import persistence.DetaiItemGroupDto;

public class DetaiItemDaoImpl implements DetaiItemDao{
	private  final Connection connection;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public DetaiItemDaoImpl() {
		this.connection = DbManager.getConnection();;
	}
	
	
	@Override
	public List<DetaiItemDto> get() {
		List<DetaiItemDto>result = new ArrayList<DetaiItemDto>();
		String sql = "select loaihang.MaLH MaLH\n"
				+ "	  		,TenLH"
				+ "			,mathang.MaMH MaMH\n"
				+ "      	,TenMH\n"
				+ "      	, GiaBan\n"
				+ "      	, GiaMua \n"
				+ "      	, SoLuong\n"
				+ "from mathang\n"
				+ "join loaihang\n"
				+ "on mathang.MaLH=loaihang.MaLH\n"
				+ "join chitietmathang\n"
				+ "on chitietmathang.MaMH = mathang.MaMH; ";
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				result.add(new DetaiItemDto(rs.getInt("MaLH"), rs.getString("TenLH"), rs.getInt("MaMH"), rs.getString("TenMH"), rs.getDouble("GiaBan"), rs.getDouble("GiaMua"), rs.getInt("MaLH")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
}
