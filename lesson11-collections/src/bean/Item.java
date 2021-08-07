package bean;

import java.util.Objects;

public class Item {
	private int itemId;
	private int storeId;
	private String name;
	private double price;

	public Item() {
	}

	public Item(int storeId, int itemId, String name, double price) {
		this.itemId = itemId;
		this.storeId = storeId;
		this.name = name;
		this.price = price;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int id) {
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

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Item)) {
			return false;
		}
		
		Item that = (Item)obj;
		
		return getStoreId() == that.getStoreId() && getItemId() == that.getItemId();
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(storeId, itemId);
	}

	@Override
	public String toString() {
		return "Item [storeId=" + storeId + ", itemId=" + itemId + ", name=" + name + ", price=" + price + "]";
	}
	
}
