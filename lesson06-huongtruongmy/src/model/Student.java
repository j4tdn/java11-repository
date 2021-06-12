package model;

public class Student {
	private String id;
	private String name;
	private String password;
	private String birthday; 
	
	public Student() {}

	public Student(String id, String name, String password, String birthday) {		
		this.id = id;
		this.name = name;
		this.password = password;
		this.birthday = birthday;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
		
	@Override
	public String toString() {
		return "ID: " + id + " - Name: " + name + " - Password: " + password + " - Birthday: " + birthday;
	}
}