package bean;

public class Item {
	private int storeId;
	private int itemId;
	private String name;
	private double price;

	public Item() {

	}

	public Item(int storeId, int itemId, String name, double price) {
		super();
		this.storeId = storeId;
		this.itemId = itemId;
		this.name = name;
		this.price = price;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getStoreId() {
		return storeId;
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
		return "Item [storeId=" + storeId +", itemId=" + itemId + ", name=" + name + ", price=" + price + "]";
	}
	
	// this: items[j]
	// item: items[j+1]
	public int compareTo(Item item) {
		if (getStoreId() > item.getStoreId()) {
			return 1;
		}
		if (getStoreId() == item.getStoreId()) {
			return item.getItemId() - getItemId();
		}
		return 0;
		// return getItemId() - item.getItemId();
	}

}