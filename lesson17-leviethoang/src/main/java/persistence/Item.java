package persistence;

public class Item {
	private Integer id;
	private String name;
	private String color;
	
	private ItemGroup itemGroup;
	private Integer purchasePrice;
	private Integer salePrice;
	private Integer numberOfItems;
	
	
	public Item() {
	}

	public Item(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	


	public Item(Integer id, String name, ItemGroup itemGroup, Integer purchasePrice, Integer salePrice,
			Integer numberOfItems) {
		super();
		this.id = id;
		this.name = name;
		this.itemGroup = itemGroup;
		this.purchasePrice = purchasePrice;
		this.salePrice = salePrice;
		this.numberOfItems = numberOfItems;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public ItemGroup getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(ItemGroup itemGroup) {
		this.itemGroup = itemGroup;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", color=" + color + ", itemGroup=" + itemGroup
				+ ", purchasePrice=" + purchasePrice + ", salePrice=" + salePrice + ", numberOfItems=" + numberOfItems
				+ "]";
	}

	
	
	
	
	
}
