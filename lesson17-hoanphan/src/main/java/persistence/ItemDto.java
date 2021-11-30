package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;

public class ItemDto {
	
	private Integer itemId;
	private String itemName;
	private Time OrderTime;
	
	public ItemDto() {
		
	}

	public ItemDto(Integer itemId, String itemName, Time orderTime) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		OrderTime = orderTime;
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

	public Time getOrderTime() {
		return OrderTime;
	}

	public void setOrderTime(Time orderTime) {
		OrderTime = orderTime;
	}

	@Override
	public String toString() {
		return "ItemDto [itemId=" + itemId + ", itemName=" + itemName + ", OrderTime=" + OrderTime + "]";
	}
	
	

}
