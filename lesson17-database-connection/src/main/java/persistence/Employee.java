package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Employee {
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String EMAIL = "email";
	public static final String PHONE = "phone";
	public static final String ADDRESS = "address";
	public static final String PASSWORD = "password";

	
	private int id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String password;
	
	
	
	public Employee() {
	}



	public Employee(int id, String name, String email, String phone, String address, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.password = password;
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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Emplyee [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", password=" + password + "]";
	}
	
	public static Employee addResultTransformer(ResultSet rs,String returnedEmail, String returnedPassword ) throws SQLException {
		return new Employee(rs.getInt(ID),rs.getString(NAME),returnedEmail,rs.getString(PHONE),rs.getString(ADDRESS),returnedPassword);
		
	}

}
