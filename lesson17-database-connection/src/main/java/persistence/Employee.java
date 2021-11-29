package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {
	private Integer id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String password;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer id, String name, String email, String phone, String address, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", password=" + password + "]";
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static Employee addResultTransformer(ResultSet rs) {
		try {

			return new Employee(rs.getInt("manv"), rs.getString("tennv"), rs.getString("email"), rs.getString("sdt"),
					rs.getString("diachi"), rs.getString("matkhau"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
