package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemGroupDto {
	public static final String ID_ITEM_GROUP = "idItemGroup";
	public static final String NAME_ITEM_GROUP = "nameItemGroup";
	public static final String NUMBER_OF_ITEMS_BY_ITEM_GROUP = "numberOfItemsByItemGroup";
	
	
	private Integer idItemGroup;
	private String nameItemGroup;
	private Integer numberOfItemsByItemGroup;
	
	public ItemGroupDto() {
	}

	public ItemGroupDto(Integer idItemGroup, String nameItemGroup, Integer numberOfItemsByItemGroup) {
		super();
		this.idItemGroup = idItemGroup;
		this.nameItemGroup = nameItemGroup;
		this.numberOfItemsByItemGroup = numberOfItemsByItemGroup;
	}

	
	

	public Integer getIdItemGroup() {
		return idItemGroup;
	}

	public void setIdItemGroup(Integer idItemGroup) {
		this.idItemGroup = idItemGroup;
	}

	public String getNameItemGroup() {
		return nameItemGroup;
	}

	public void setNameItemGroup(String nameItemGroup) {
		this.nameItemGroup = nameItemGroup;
	}

	public Integer getNumberOfItemsByItemGroup() {
		return numberOfItemsByItemGroup;
	}

	public void setNumberOfItemsByItemGroup(Integer numberOfItemsByItemGroup) {
		this.numberOfItemsByItemGroup = numberOfItemsByItemGroup;
	}

	@Override
	public String toString() {
		return "ItemGroupDto [idItemGroup=" + idItemGroup + ", nameItemGroup=" + nameItemGroup
				+ ", numberOfItemsByItemGroup=" + numberOfItemsByItemGroup + "]";
	}

	public static ItemGroupDto addResultTransformer(ResultSet rs) throws SQLException {
		return new ItemGroupDto(rs.getInt(ItemGroupDto.ID_ITEM_GROUP),
			rs.getString(ItemGroupDto.NAME_ITEM_GROUP),
			rs.getInt(ItemGroupDto.NUMBER_OF_ITEMS_BY_ITEM_GROUP));
	}
}
