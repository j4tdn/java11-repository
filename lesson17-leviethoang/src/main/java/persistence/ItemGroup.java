package persistence;

public class ItemGroup {
	public static final String ITEM_GROUP_ID = "id";
	public static final String ITEM_GROUP_NAME = "name";
	
	
	private Integer id;
	private String name;
	
	
	
	public ItemGroup() {
	}
	
	
	public ItemGroup(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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
