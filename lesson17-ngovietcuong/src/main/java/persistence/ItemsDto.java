package persistence;

public class ItemsDto {
	private int idItemGroup;
	private String nameItemGroups;
	private int idItem;
	private String nameItem;
	private String size;
	private int price;
	private int purchasePrice;
	private int quantity;

	public ItemsDto() {
		
	}

	public ItemsDto(int idItemGroup, String nameItemGroups, int idItem, String nameItem, String size, int price,
			int purchasePrice, int quantity) {
		super();
		this.idItemGroup = idItemGroup;
		this.nameItemGroups = nameItemGroups;
		this.idItem = idItem;
		this.nameItem = nameItem;
		this.size = size;
		this.price = price;
		this.purchasePrice = purchasePrice;
		this.quantity = quantity;
	}

	public int getIdItemGroup() {
		return idItemGroup;
	}

	public void setIdItemGroup(int idItemGroup) {
		this.idItemGroup = idItemGroup;
	}

	public String getNameItemGroups() {
		return nameItemGroups;
	}

	public void setNameItemGroups(String nameItemGroups) {
		this.nameItemGroups = nameItemGroups;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getNameItem() {
		return nameItem;
	}

	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ItemsDto [idItemGroup=" + idItemGroup + ", nameItemGroups=" + nameItemGroups + ", idItem=" + idItem
				+ ", nameItem=" + nameItem + ", size=" + size + ", price=" + price + ", purchasePrice=" + purchasePrice
				+ ", quantity=" + quantity + "]";
	}
}
