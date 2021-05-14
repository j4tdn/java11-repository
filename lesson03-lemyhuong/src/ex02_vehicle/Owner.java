package ex02_vehicle;

public class Owner {
	//Owner: id, name, address, phone
	private String id;
	private String name;
	private String address;
	private String phone;

	public Owner() {
	}

	public Owner(String id, String name, String address, String phone) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}
	

}
