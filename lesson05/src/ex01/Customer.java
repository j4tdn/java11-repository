package ex01;

public class Customer {
	private String id;
	private String fullname;
	private String phone;
	private String adress;
	
	public Customer() {
	}

	public String getId() {
		return id;
	}

	public String getFullname() {
		return fullname;
	}

	public String getPhone() {
		return phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Customer(String id, String fullname, String phone, String adress) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.phone = phone;
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", fullname=" + fullname + ", phone=" + phone + ", adress=" + adress + "]";
	}
	
	

}
