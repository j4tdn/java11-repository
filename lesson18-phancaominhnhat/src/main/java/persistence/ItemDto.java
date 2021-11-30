package persistence;

import java.sql.Time;

public class ItemDto {
	private Integer itemId;
	private String itemName;
	private Time timeOrder;
	
	public ItemDto() {
	}
	
	public ItemDto(Integer itemId, String itemName, Time timeOrder) {
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

	public Time getTimeOrder() {
		return timeOrder;
	}

	public void setTimeOrder(Time timeOrder) {
		this.timeOrder = timeOrder;
	}

	@Override
	public String toString() {
		return "ItemDto [itemId=" + itemId + ", itemName=" + itemName + ", timeOrder=" + timeOrder + "]";
	}
}
