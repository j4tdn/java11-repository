package persistence;

import java.time.LocalTime;

public class PurchaseOrderDto {
	private int itemID;
	private String itemName;
	private LocalTime orderDate;
	public PurchaseOrderDto(int itemID, String itemName, LocalTime orderDate) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.orderDate = orderDate;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public LocalTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalTime orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "PurchaseOrderDto [itemID=" + itemID + ", itemName=" + itemName + ", orderDate=" + orderDate + "]";
	}
	
	
}
