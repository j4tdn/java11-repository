package persistence;


// Mapping with table NhanVien
public class Employee {
	private Integer id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String passworld;
	
	public Employee() {
	}

	public Employee(Integer id, String name, String email, String phone, String address, String passworld) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.passworld = passworld;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassworld() {
		return passworld;
	}

	public void setPassworld(String passworld) {
		this.passworld = passworld;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", passworld=" + passworld + "]";
	}
	
	
	
}
