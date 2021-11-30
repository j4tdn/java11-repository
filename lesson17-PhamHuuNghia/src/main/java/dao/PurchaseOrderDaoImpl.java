package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;
import persistence.DetailItemPurchaseDto;
import persistence.Item;
import persistence.PurchaseOrderDto;
import utils.DateUtils;

public class PurchaseOrderDaoImpl implements PurchaseOrderDao{
	
	private final Connection connection;
	private PreparedStatement pst;
	private ResultSet rs;

	public PurchaseOrderDaoImpl() {
		this.connection = DbManager.getConnection();
		;
	}
	
	@Override
	public List<PurchaseOrderDto> get(LocalDate date) {
		List<PurchaseOrderDto> result = new ArrayList<PurchaseOrderDto>();
		String sql = "select mathang.MaMH, mathang.TenMH, ThoiGianDatHang\n"
				+ "From mathang\n"
				+ "JOIN chitietdonhang\n"
				+ "On mathang.MaMH=chitietdonhang.MaMH\n"
				+ "Join donhang\n"
				+ "On chitietdonhang.MaDH=donhang.MaDH\n"
				+ "Where cast(dh.ThoiGianDatHang AS DATE)=?";
		try {
			pst = connection.prepareCall(sql);
			pst.setDate(1, DateUtils.toDate(date));
			rs = pst.executeQuery();
			while(rs.next()) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
