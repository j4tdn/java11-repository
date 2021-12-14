package persistence;

public class Item {
	private Integer id;
	private String name;
	private String color;
	
	// Mapping 1-N with Item
	private ItemGroup ItemGroup;
	
	public Item() {
	}

	public Item(Integer id, String name, String color) {
		this.id = id;
		this.name = name;
		this.color = color;
	}
	
	public Item(Integer id, String name, String color, persistence.ItemGroup itemGroup) {
		this.id = id;
		this.name = name;
		this.color = color;
		ItemGroup = itemGroup;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public ItemGroup getItemGroup() {
		return ItemGroup;
	}

	public void setItemGroup(ItemGroup itemGroup) {
		ItemGroup = itemGroup;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", color=" + color + ", ItemGroup=" + ItemGroup + "]";
	}
	
}


