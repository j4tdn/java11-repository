package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ItemGroupDto {
	public static final String ITEM_GROUP_ID   = "igId";
	public static final String ITEM_GROUP_NAME = "igName";
	public static final String NUMBER_OF_ITEMS = "numberOfItems";
	public static final String TIME_DELIVERY = "timeDelivery";

	
	private Integer igId;
	private String igName;
	private Integer numberOfItems;
	private LocalDate dateOrder;
	
	public ItemGroupDto() {
	}
	
	public ItemGroupDto(Integer igId, String igName, Integer numberOfItems) {
		this.igId = igId;
		this.igName = igName;
		this.numberOfItems = numberOfItems;
	}
	
	

	public ItemGroupDto(Integer igId, String igName, LocalDate dateOrder) {
		super();
		this.igId = igId;
		this.igName = igName;
		this.dateOrder = dateOrder;
	}
	
	public LocalDate getDateOrder() {
		return dateOrder;
	}
	
	public void setDateOrder(LocalDate dateOrder) {
		this.dateOrder = dateOrder;
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
		return "ItemGroupDto [igId=" + igId + ", igName=" + igName + ", dateOrder=" + dateOrder + "]";
	}


	public static ItemGroupDto addResultTransfomer(ResultSet rs) throws SQLException {
		return new ItemGroupDto(
				rs.getInt(ItemGroupDto.ITEM_GROUP_ID), 
				rs.getString(ItemGroupDto.ITEM_GROUP_NAME),
				rs.getInt(ItemGroupDto.NUMBER_OF_ITEMS)
		);
	}
	public static ItemGroupDto addResultOrderByDate(ResultSet rs) throws SQLException{
		return new ItemGroupDto(
				rs.getInt(ItemGroupDto.ITEM_GROUP_ID),
				rs.getString(ItemGroupDto.ITEM_GROUP_NAME),
				rs.getDate(ItemGroupDto.TIME_DELIVERY).toLocalDate()
				);
				
	}
}
