package persistence;

public class Item {
	private Integer id;
	private String name;
	private String orderTime;
	
	public Item() {
	}

	public Item(Integer id, String name, String orderTime) {
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

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", orderTime=" + orderTime + "]";
	}

	
}
