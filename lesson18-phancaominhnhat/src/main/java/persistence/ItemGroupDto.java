package persistence;

public class ItemGroupDto {
	private Integer igId;
	private String nameIgId;
	private Integer amount;
	
	public ItemGroupDto() {
	}

	public ItemGroupDto(Integer igId, String nameIgId, Integer amount) {
		this.igId = igId;
		this.nameIgId = nameIgId;
		this.amount = amount;
	}

	public Integer getIgId() {
		return igId;
	}

	public void setIgId(Integer igId) {
		this.igId = igId;
	}

	public String getNameIgId() {
		return nameIgId;
	}

	public void setNameIgId(String nameIgId) {
		this.nameIgId = nameIgId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ItemGroupDto [igId=" + igId + ", nameIgId=" + nameIgId + ", amount=" + amount + "]";
	}
	
}
