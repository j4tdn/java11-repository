package bean;

public class Item {
	private int storeId;
	private int itemId;
	private String name;
	private double price;

	public Item() {
	}

	public Item(int storeId,int id, String name, double price) {
		this.storeId = storeId;
		this.itemId = id;
		this.name = name;
		this.price = price;
	}

	public int getItemId() {
		return itemId;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setItemId(int id) {
		this.itemId = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof Item) {
			return false;
		}
		Item that = (Item)obj;
		return getStoreId() == that.getStoreId() && getItemId() == that.getItemId();
	}
	

	@Override
	public String toString() {
		return "Item [storeId=" + storeId +", itemId=" + itemId + ", name=" + name + ", price=" + price + "]";
	}
}
