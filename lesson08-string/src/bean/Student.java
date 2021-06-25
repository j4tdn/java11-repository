package bean;

public class Student {
  private String name;
  private String phone;
  private boolean gender;
  private String hobbies;
  
  public Student() {
}

public Student(String name, String phone, boolean gender, String hobbies) {
	super();
	this.name = name;
	this.phone = phone;
	this.gender = gender;
	this.hobbies = hobbies;
}

public String getName() {
	return name;
}

public String getPhone() {
	return phone;
}

public boolean isGender() {
	return gender;
}

public String getHobbies() {
	return hobbies;
}

public void setName(String name) {
	this.name = name;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public void setGender(boolean gender) {
	this.gender = gender;
}

public void setHobbies(String hobbies) {
	this.hobbies = hobbies;
}

@Override
public String toString() {
	return "Student [name=" + name + ", phone=" + phone + ", gender=" + gender + ", hobbies=" + hobbies + "]";
}
  
}
