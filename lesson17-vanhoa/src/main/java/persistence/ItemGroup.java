package persistence;

import java.util.List;

public class ItemGroup {
	private Integer id;
	private String name;
	private List<Item> item;

	public ItemGroup() {
	}

	public ItemGroup(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public ItemGroup(Integer id, String name, List<Item> item) {
		this.id = id;
		this.name = name;
		this.item = item;
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

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "ItemGroup [id=" + id + ", name=" + name + ", item=" + item + "]";
	}

}
