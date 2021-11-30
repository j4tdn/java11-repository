package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

import utils.DateUtils;

public class ItemDto {
	public static final String ITEM_ID = "itemId";
	public static final String ITEM_NAME = "itemName";
	public static final String TIME_ORDER = "timeOrder";
	
	private Integer itemId;
	private String itemName;
	private LocalTime timeOrder;
	
	
	public ItemDto() {
	}


	public ItemDto(Integer itemId, String itemName, LocalTime timeOrder) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.timeOrder = timeOrder;
	}


	public Integer getItemId() {
		return itemId;
	}


	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public LocalTime getTimeOrder() {
		return timeOrder;
	}


	public void setTimeOrder(LocalTime timeOrder) {
		this.timeOrder = timeOrder;
	}


	@Override
	public String toString() {
		return "ItemDto [itemId=" + itemId + ", itemName=" + itemName + ", timeOrder=" + timeOrder + "]";
	}


	public static ItemDto addResultTransformer(ResultSet rs) throws SQLException {
		return new ItemDto(rs.getInt(ItemDto.ITEM_ID),
				rs.getString(ItemDto.ITEM_NAME),
				DateUtils.toLocalTime(rs.getTime(ItemDto.TIME_ORDER)));
	}
}
