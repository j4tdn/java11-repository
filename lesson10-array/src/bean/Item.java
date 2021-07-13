package bean;

public class Item {
	private int storeId;
	private int itemId;
	private String name;
	private double price;

	public Item() {
	}

	public Item(int id, String name, double price) {
		super();
		this.itemId = id;
		this.name = name;
		this.price = price;
	}

	public Item(int storeId, int id, String name, double price) {
		super();
		this.storeId = storeId;
		this.itemId = id;
		this.name = name;
		this.price = price;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getId() {
		return itemId;
	}

	public void setId(int id) {
		this.itemId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [storeId=" + storeId + ", itemId=" + itemId + ", name=" + name + ", price=" + price + "]";
	}

}
