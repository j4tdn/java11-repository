package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemGroupDto {

	public static final String ITEM_GROUP_ID = "igId";
	public static final String ITEM_GROUP_NAME = "igName";
	public static final String NUMBERS_ID = "numberOfItems";

	private Integer id;
	private String igname;
	private Integer numberOfItems;

	public ItemGroupDto() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ItemGroupDto [id=" + id + ", igname=" + igname + ", numberOfItems=" + numberOfItems + "]";
	}

	public ItemGroupDto(Integer id, String igname, Integer numberOfItems) {
		super();
		this.id = id;
		this.igname = igname;
		this.numberOfItems = numberOfItems;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIgname() {
		return igname;
	}

	public void setIgname(String igname) {
		this.igname = igname;
	}

	public Integer getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(Integer numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public static ItemGroupDto transformer(ResultSet rs) {
		try {
			return new ItemGroupDto(rs.getInt(ITEM_GROUP_ID), rs.getString(ITEM_GROUP_NAME), rs.getInt(NUMBERS_ID));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
