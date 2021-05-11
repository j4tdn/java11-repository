package bt2;

public class Owner {
	private String id;
	private String name;
	
	
	public Owner() {
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public Owner(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + "]";
	}
}
