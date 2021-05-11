package bai2;

public class Owner {
	private int id;
	private String name;
	private String address;
	
	public Owner() {
	}

	public Owner(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
