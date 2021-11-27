package persistence;

public class ItemGroupDto {
	
	public static final String ITEM_GROUP_ID = "igID";
	public static final String ITEM_GROUP_NAME = "igName";
	public static final String NUMBER_OF_ITEMS = "numberOfItems";
	
	private Integer igId;
	private String igName;
	private Long numberOfItems;

	public ItemGroupDto() {
	}

	public ItemGroupDto(Integer igId, String igName, Long numberOfItems) {
		super();
		this.igId = igId;
		this.igName = igName;
		this.numberOfItems = numberOfItems;
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

	public Long getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(Long numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	@Override
	public String toString() {
		return "ItemGroupDto [igId=" + igId + ", igName=" + igName + ", numberOfItems=" + numberOfItems + "]";
	}

}
