package bai05;

public class Customer {
	private String idkh;
	private String name;
	private String phone;
	private String address;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String idkh, String name, String phone, String address) {
		super();
		this.idkh = idkh;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public String getIdkh() {
		return idkh;
	}

	public void setIdkh(String idkh) {
		this.idkh = idkh;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Customer [idkh=" + idkh + ", name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}
}
