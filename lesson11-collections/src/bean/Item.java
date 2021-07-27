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

	public int getstoreId() {
		return storeId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
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
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(!(o instanceof Item)) {
			return false;
		}
		
		Item that = (Item)o;
		return getstoreId() == that.getstoreId() && getItemId() == that.getItemId();
	}
	
	@Override
	public String toString() {
		return "Item [storeId=" + storeId +", itemId=" + itemId + ", name=" + name + ", price=" + price + "]";
	}
	
	}
