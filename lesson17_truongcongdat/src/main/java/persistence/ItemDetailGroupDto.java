package persistence;

public class ItemDetailGroupDto {
	private Integer igId;
	private String igName;
	private Integer itemId;
	private String itemName;
	private Integer solvePrice;
	private Integer buyPrice;
	private Integer number;
	
	public ItemDetailGroupDto() {
	}
	
	public ItemDetailGroupDto(Integer igId, String igName, Integer itemId, String itemName, Integer solvePrice,
			Integer buyPrice, Integer number) {
		this.igId = igId;
		this.igName = igName;
		this.itemId = itemId;
		this.itemName = itemName;
		this.solvePrice = solvePrice;
		this.buyPrice = buyPrice;
		this.number = number;
	}

	public Integer getIgId() {
		return igId;
	}
	public void setIgId(Integer igId) {
		this.igId = igId;
	}
	public String getIgName() {
		return igName;
	}
	public void setIgName(String igName) {
		this.igName = igName;
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
	public Integer getSolvePrice() {
		return solvePrice;
	}
	public void setSolvePrice(Integer solvePrice) {
		this.solvePrice = solvePrice;
	}
	public Integer getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(Integer buyPrice) {
		this.buyPrice = buyPrice;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "ItemDetailGroupDto [igId=" + igId + ", igName=" + igName + ", itemId=" + itemId + ", itemName="
				+ itemName + ", solvePrice=" + solvePrice + ", buyPrice=" + buyPrice + ", number=" + number + "]";
	}
	
	
}
