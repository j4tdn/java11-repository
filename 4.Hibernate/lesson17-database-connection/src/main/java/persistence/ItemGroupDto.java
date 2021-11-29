package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemGroupDto {

	private Integer igId;
	private String igName;
	private Integer numberOfItems;
	
	public static final String ITEM_GROUP_ID = "igId";
	public static final String ITEM_GROUP_NAME = "igName";
	public static final String NUMBER_OF_ITEMS = "numberOfItems";
	
	public ItemGroupDto() {
		
	}

	public ItemGroupDto(Integer igId, String igName, Integer numberOfItems) {
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

	public Integer getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(Integer numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	@Override
	public String toString() {
		return "ItemGroupDto [igId=" + igId + ", igName=" + igName + ", numberOfItems=" + numberOfItems + "]";
	}
	
	public static ItemGroupDto addResultTransfomer(ResultSet rs) throws SQLException {
		return new ItemGroupDto(
				rs.getInt(ITEM_GROUP_ID), 
				rs.getString(ITEM_GROUP_NAME), 
				rs.getInt(NUMBER_OF_ITEMS));		
	}
	
	
}
