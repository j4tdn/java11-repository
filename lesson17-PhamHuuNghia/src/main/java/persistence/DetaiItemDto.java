package persistence;

public class DetaiItemDto {
	private int idItemGroup;
	private String nameItemGroup;
	private int idItem;
	private String nameItem;
	private double price;
	private double costPrice;
	private int stock;
	public int getIdItemGroup() {
		return idItemGroup;
	}
	public void setIdItemGroup(int idItemGroup) {
		this.idItemGroup = idItemGroup;
	}
	public String getNameItemGroup() {
		return nameItemGroup;
	}
	public void setNameItemGroup(String nameItemGroup) {
		this.nameItemGroup = nameItemGroup;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public DetaiItemDto(int idItemGroup, String nameItemGroup, int idItem, String nameItem, double price,
			double costPrice, int stock) {
		super();
		this.idItemGroup = idItemGroup;
		this.nameItemGroup = nameItemGroup;
		this.idItem = idItem;
		this.nameItem = nameItem;
		this.price = price;
		this.costPrice = costPrice;
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "DetaiItemDto [idItemGroup=" + idItemGroup + ", nameItemGroup=" + nameItemGroup + ", idItem=" + idItem
				+ ", nameItem=" + nameItem + ", price=" + price + ", costPrice=" + costPrice + ", stock=" + stock + "]";
	} 
	
	
}
