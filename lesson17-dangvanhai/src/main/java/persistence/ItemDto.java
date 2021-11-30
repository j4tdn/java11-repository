package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class ItemDto {
	public static final String ITEM_ID = "MaMH";
	public static final String ITEM_NAME = "TenMH";
	public static final String TIME_ORDER = "ThoiGianDatHang";

	private Integer id;
	private String igName;
	private LocalTime timeOrder;

	public ItemDto() {
	}
	
	public ItemDto(Integer id, String igName, LocalTime timeOrder) {
		this.id = id;
		this.igName = igName;
		this.timeOrder = timeOrder;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIgName() {
		return igName;
	}

	public void setIgName(String igName) {
		this.igName = igName;
	}

	public LocalTime getTimeOrder() {
		return timeOrder;
	}

	public void setTimeOrder(LocalTime timeOrder) {
		this.timeOrder = timeOrder;
	}

	@Override
	public String toString() {
		return "ItemDto [id=" + id + ", igName=" + igName + ", timeOrder=" + timeOrder + "]";
	}

	public static ItemDto addResultTransformer(ResultSet rs) throws SQLException {
		LocalTime time = rs.getTimestamp(ItemDto.TIME_ORDER).toLocalDateTime().toLocalTime();
		return new ItemDto(rs.getInt(ItemDto.ITEM_ID), rs.getString(ItemDto.ITEM_NAME), time);
	}

}
