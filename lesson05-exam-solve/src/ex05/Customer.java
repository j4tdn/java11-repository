package ex05;

public class Customer {
	private String fullname;
	private String id;
	private String phone;
	private String address;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String fullname, String id, String phone, String address) {
		this.fullname = fullname;
		this.id = id;
		this.phone = phone;
		this.address = address;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
