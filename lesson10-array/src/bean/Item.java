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

	public Item(int storeId, int itemId, String name, double price) {
		super();
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

	public void setId(int itemId) {
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

	
	public int compareTo(Item item) {
		if(getStoreId() > item.getStoreId()) {
			return 1;
		}
		
		if(getStoreId() == item.getStoreId()) {
		return getItemId() - item.getItemId();
		}
		
		return 0;
	}
	
	@Override
	public String toString() {
		return "Item [storeId = " + storeId + ", id=" + itemId + ", name=" + name + ", price=" + price + "]";
	}

}
