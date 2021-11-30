package persistence;

public class ItemGroupAndItemDto {
	private Integer id;
	private String name;
	private Double price;
	private Double buyPrice;
	private Integer amount;

	private ItemGroup itemGroup;

	public ItemGroupAndItemDto() {
		// TODO Auto-generated constructor stub
	}

	public ItemGroupAndItemDto(Integer id, String name, Double price, Double buyPrice, Integer amount) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.buyPrice = buyPrice;
		this.amount = amount;
	}

	public ItemGroupAndItemDto(Integer id, String name, Double price, Double buyPrice, Integer amount,
			ItemGroup itemGroup) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.buyPrice = buyPrice;
		this.amount = amount;
		this.itemGroup = itemGroup;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public ItemGroup getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(ItemGroup itemGroup) {
		this.itemGroup = itemGroup;
	}

	@Override
	public String toString() {
		return "ItemGroupAndItemDto [id=" + id + ", name=" + name + ", price=" + price + ", buyPrice=" + buyPrice
				+ ", amount=" + amount + ", itemGroup=" + itemGroup + "]";
	}

}
