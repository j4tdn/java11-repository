package bai5;

public class Customer {
	private String id;
	private String fullName;
	private String phone;
	private String address;
	
	public Customer() {
	}

	public Customer(String id, String fullname, String phone, String address) {
		this.id = id;
		this.fullName = fullName;
		this.phone = phone;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullname() {
		return fullName;
	}

	public void setFullname(String fullName) {
		this.fullName = fullName;
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

	@Override
	public String toString() {
		return "Customer [id=" + id + ", fullname=" + fullName + ", phone=" + phone + ", address=" + address + "]";
	}
}
