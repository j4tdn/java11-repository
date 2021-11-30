package persistence;

import java.util.List;

public class ItemGroup {
	private Integer id;
	private String name;

	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public ItemGroup() {

	}

	public ItemGroup(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public ItemGroup(Integer id, String name, List<Item> items) {
		super();
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

	@Override
	public String toString() {
		return "ItemGroup [id=" + id + ", name=" + name + "]";
	}

}
