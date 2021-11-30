package persistencce;

public class Item {
	private Integer id;
	private String name;
	;
	
	
	public Item() {
	}


	public Item(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;

	}
	

	public Item(Integer id, String name, String color) {
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
		return "Item [id=" + id + ", name=" + name + "]";
	}
	

}
