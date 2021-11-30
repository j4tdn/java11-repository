package persistence;

public class ItemsDto {
	private Integer igId;
	private String igName;
	private String itemId;
	private String itemName;
	private Double giaBan;
	private Double giaMua;
	private Integer amount;
	private String sizeId;
	
	public ItemsDto() {
		// TODO Auto-generated constructor stub
	}

	public ItemsDto(Integer igId, String igName, String itemId, String itemName, Double giaBan, Double giaMua,
			Integer amount, String sizeId) {
		this.igId = igId;
		this.igName = igName;
		this.itemId = itemId;
		this.itemName = itemName;
		this.giaBan = giaBan;
		this.giaMua = giaMua;
		this.amount = amount;
		this.sizeId = sizeId;
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

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(Double giaBan) {
		this.giaBan = giaBan;
	}

	public Double getGiaMua() {
		return giaMua;
	}

	public void setGiaMua(Double giaMua) {
		this.giaMua = giaMua;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getSizeId() {
		return sizeId;
	}

	public void setSizeId(String sizeId) {
		this.sizeId = sizeId;
	}

	@Override
	public String toString() {
		return "ItemsDto [igId=" + igId + ", igName=" + igName + ", itemId=" + itemId + ", itemName=" + itemName
				+ ", giaBan=" + giaBan + ", giaMua=" + giaMua + ", amount=" + amount + ", sizeId=" + sizeId + "]";
	}
	
	
}
