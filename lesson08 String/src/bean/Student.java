package bean;

public class Student {
	private String name;
	private String phone;
	private boolean gender;
	private String bobbies;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String name, String phone, boolean gender, String bobbies) {
		this.name = name;
		this.phone = phone;
		this.gender = gender;
		this.bobbies = bobbies;
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
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getBobbies() {
		return bobbies;
	}
	public void setBobbies(String bobbies) {
		this.bobbies = bobbies;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", phone=" + phone + ", gender=" + gender + ", bobbies=" + bobbies + "]";
	}
	

}
