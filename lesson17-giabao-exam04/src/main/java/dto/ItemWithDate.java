package dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class ItemWithDate {
	public static final String ITEM_ID = "itemGroupId";
	public static final String ITEM_NAME = "igName";
	public static final String SALE_TIME = "saleTime";
	
	private Integer id;
	private String name;
	private LocalTime saleTime;
	
	public ItemWithDate() {
		// TODO Auto-generated constructor stub
	}

	public ItemWithDate(Integer id, String name, LocalTime saleTime) {
		this.id = id;
		this.name = name;
		this.saleTime = saleTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalTime getSaleTime() {
		return saleTime;
	}

	public void setSaleTime(LocalTime saleTime) {
		this.saleTime = saleTime;
	}

	@Override
	public String toString() {
		return "ItemWithDate [id=" + id + ", name=" + name + ", saleTime=" + saleTime + "]";
	}
	
	public static ItemWithDate addResultTransfomer(ResultSet rs) throws SQLException {
		return new ItemWithDate(rs.getInt(ItemWithDate.ITEM_ID), 
								rs.getString(ItemWithDate.ITEM_NAME),
								rs.getTime(ItemWithDate.SALE_TIME).toLocalTime());
	}
	
}