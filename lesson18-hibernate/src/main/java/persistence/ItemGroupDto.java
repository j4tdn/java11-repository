package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Entity;
import javax.persistence.Table;

public class ItemGroupDto {
	private Integer itemGroupId;
	private String igName;
	private Integer numberOfItems;

	public static final String ITEM_GROUP_ID = "itemGroupId";
	public static final String ITEM_GROUP_NAME = "igName";
	public static final String NUMBER_OF_ITEMS = "numberOfItems";

	public ItemGroupDto() {
		
	}

	public ItemGroupDto(Integer itemGroupId, String igName, Integer numberOfItems) {
		super();
		this.itemGroupId = itemGroupId;
		this.igName = igName;
		this.numberOfItems = numberOfItems;
	}

	public Integer getItemGroupId() {
		return itemGroupId;
	}

	public void setItemGroupId(Integer itemGroupId) {
		this.itemGroupId = itemGroupId;
	}

	public String getIgName() {
		return igName;
	}

	public void setIgName(String igName) {
		this.igName = igName;
	}

	public Integer getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(Integer numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	@Override
	public String toString() {
		return "\n ItemGroupDto [itemGroupId=" + itemGroupId + ","
				+ " igName=" + igName + ", "
				+ "numberOfItems=" + numberOfItems
				+ "]\n";
	}
	

}