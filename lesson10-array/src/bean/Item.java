package bean;

public class Item implements Comparable<Item> {
	private int storeId;
	private int itemId;
	private String name;
	private double price;
	
	public Item() {
	}
	
	public Item(int itemId, String name, double price) {
		this.itemId = itemId;
		this.name = name;
		this.price = price;
	}

	public Item(int storeId, int itemId, String name, double price) {
		this.storeId = storeId;
		this.itemId = itemId;
		this.name = name;
		this.price = price;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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
	
	
	
	// o1: this: item[j]
	// o2: item: item[j+1]
	@Override
	public int compareTo(Item item) {
		return Double.compare(getPrice(), item.getPrice());
	}

	@Override
	public String toString() {
		return "Item [storeId=" + storeId + ", itemId=" + itemId + ", name=" + name + ", price=" + price + "]";
	}
	
}
