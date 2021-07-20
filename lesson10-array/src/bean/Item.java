package bean;

public class Item implements Comparable<Item> {
	private int storeId;
	private int ItemId;
	private String name;
	private double price;
	
	public Item() {
	}

	public Item(int itemId, String name, double price) {
		this.ItemId = itemId;
		this.name = name;
		this.price = price;
	}
	
	

	public Item(int storeId, int itemId, String name, double price) {
		this.storeId = storeId;
		this.ItemId = itemId;
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
		return ItemId;
	}

	public void setId(int id) {
		this.ItemId = id;
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
	
	//this: item[j]
	//item: items[j+1]
	@Override
	public int compareTo(Item item) {
		return getStoreId() - item.getStoreId();
		//return Double.compare(item.getPrice(), getPrice());
	}

	@Override
	public String toString() {
		return "Item [storeId=" + storeId +", itemId=" + ItemId + ", name=" + name + ", price=" + price + "]";
	}
}
