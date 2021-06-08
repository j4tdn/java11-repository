package ex05;

public class Customer {
	private String id;
	private String fullName;
	private String phone;
	private String address;
	
	public Customer() {
		
	}

	public Customer(String id, String fullName, String phone, String address) {
		super();
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
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
		return "Customer [id=" + id + ", fullName=" + fullName + ", phone=" + phone + ", address=" + address + "]";
	}
	
}
