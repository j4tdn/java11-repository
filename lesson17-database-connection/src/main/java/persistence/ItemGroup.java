package persistence;

import java.util.List;

// Mapped with LoaiHang table
public class ItemGroup {
	private Integer id;
	private String name;
	
	// Mapping 1-N with Item
	private List<Item> items;
	
	public ItemGroup() {
	}

	public ItemGroup(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public ItemGroup(Integer id, String name, List<Item> items) {
		this.id = id;
		this.name = name;
		this.items = items;
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

	public List<Item> getItems() {
		return items;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "ItemGroup [id=" + id + ", name=" + name + ", items=" + items + "]";
	}
}
