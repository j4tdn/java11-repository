package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemGroupDto {
	private Integer itemGroupId;
	private String igName;
	private Integer numberOfItems;

	public static final String ITEM_GROUP_ID = "itemGroupId";
	public static final String ITEM_GROUP_NAME = "igName";
	public static final String NUMBER_OF_ITEMS = "numberOfItems";

	public ItemGroupDto() {
		// TODO Auto-generated constructor stub
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
		return "ItemGroupDto [itemGroupId=" + itemGroupId + ", igName=" + igName + ", numberOfItems=" + numberOfItems
				+ "]";
	}
	
	public static ItemGroupDto addResultTransfomer(ResultSet rs) throws SQLException {
		return new ItemGroupDto(rs.getInt(ItemGroupDto.ITEM_GROUP_ID), 
								rs.getString(ItemGroupDto.ITEM_GROUP_NAME),
								rs.getInt(ItemGroupDto.NUMBER_OF_ITEMS));
	}

}