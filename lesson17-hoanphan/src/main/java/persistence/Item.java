package persistence;

public class Item {
	private Integer id;
	private String name;
	private String MauSac;
	
	
	//Mapping N-1 with ItemGroup
	private ItemGroup itemGroup;
	
	

	public Item(String name) {
		super();
		this.name = name;
	}
	
	public Item(Integer id, String name, ItemGroup itemGroup) {
		super();
		this.id = id;
		this.name = name;
		this.itemGroup = itemGroup;
	}
	
	public Item(Integer id, String name, String mauSac, ItemGroup itemGroup) {
		super();
		this.id = id;
		this.name = name;
		MauSac = mauSac;
		this.itemGroup = itemGroup;
	}
	public Item(Integer id, String name, String mauSac) {
		super();
		this.id = id;
		this.name = name;
		MauSac = mauSac;
	
	}
	
	public Item() {
	
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

	public String getMauSac() {
		return MauSac;
	}

	public void setMauSac(String mauSac) {
		MauSac = mauSac;
	}

	public ItemGroup getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(ItemGroup itemGroup) {
		this.itemGroup = itemGroup;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", MauSac=" + MauSac + ", itemGroup=" + itemGroup + "]";
	}
	
	
	
	
	
	
}
