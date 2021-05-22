package entities;

public class Customer {
	private String MKH;
	private String name;
	private String telephone;
	private String address;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String mKH, String name, String telephone, String address) {
		super();
		MKH = mKH;
		this.name = name;
		this.telephone = telephone;
		this.address = address;
	}

	public String getMKH() {
		return MKH;
	}

	public void setMKH(String mKH) {
		MKH = mKH;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
