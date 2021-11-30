package persistence;

import java.time.LocalTime;

public class ItemDto {
	private Integer id;
	private String name;
	private LocalTime orderTime;
	
	public ItemDto() {
	}

	public ItemDto(Integer id, String name, LocalTime orderTime) {
		this.id = id;
		this.name = name;
		this.orderTime = orderTime;
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

	public LocalTime getOrderDate() {
		return orderTime;
	}

	public void setOrderDate(LocalTime orderTime) {
		this.orderTime = orderTime;
	}

	@Override
	public String toString() {
		return "ItemDto [id=" + id + ", name=" + name + ", orderTime=" + orderTime + "]";
	}
}
