package persistence;

public class ItemGroupDto {

	public static String ITEM_GROUP_ID = "groupId";
	public static String ITEM_GROUP_NAME = "groupName";
	public static String QTY = "qty";

	private Integer groupId;

	private String groupName;

	private Integer qty;

	public ItemGroupDto() {
	}

	@Override
	public String toString() {
		return groupId + " | " + groupName + " | " + qty ;
	}

} 