package persistence;

import java.util.List;

public class ItemGroup {
	private Integer id;
	private String name;
	
	// Mapping 1-N with item
	private List<Item> item;
	
	public ItemGroup() {
	}
	
	
	public ItemGroup(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public ItemGroup(Integer id, String name, List<Item> item) {
		super();
		this.id = id;
		this.name = name;
		this.item = item;
	}


	public List<Item> getItem() {
		return item;
	}


	public void setItem(List<Item> item) {
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


	

	@Override
	public String toString() {
		return "ItemGroup [id=" + id + ", name=" + name + ", item=" + item + "]";
	}


	
	
}
