package persistence;

import java.time.LocalTime;

public class ItemDto {
	private Integer idItem;
	private String name;
	private LocalTime orderTime;
	
	public ItemDto() {
	}

	public ItemDto(Integer idItem, String name, LocalTime orderTime) {
		this.idItem = idItem;
		this.name = name;
		this.orderTime = orderTime;
	}

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalTime orderTime) {
		this.orderTime = orderTime;
	}

	@Override
	public String toString() {
		return "ItemDto [idItem=" + idItem + ", name=" + name + ", orderTime=" + orderTime + "]";
	}
	
}
