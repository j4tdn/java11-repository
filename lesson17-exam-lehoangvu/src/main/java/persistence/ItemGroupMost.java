package persistence;

public class ItemGroupMost {
	private Integer id;
	private String name;
	private Integer itemId;
	private String itemName;
	private Integer price;
	private Integer purchasePrice;
	private Integer amount;
	public ItemGroupMost() {
		super();
	}
	public ItemGroupMost(Integer id, String name, Integer itemId, String itemName, Integer price, Integer purchasePrice,
			Integer amount) {
		super();
		this.id = id;
		this.name = name;
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.purchasePrice = purchasePrice;
		this.amount = amount;
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
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Integer purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "ItemGroupMost [id=" + id + ", name=" + name + ", itemId=" + itemId + ", itemName=" + itemName
				+ ", price=" + price + ", purchasePrice=" + purchasePrice + ", amount=" + amount + "]";
	}
	
	
	

}
