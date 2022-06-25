package bean;

import java.time.LocalDate;
import java.util.Arrays;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import validation.StartsWith;

public class Student {
	private String id;
	
	@NotNull(message = "Fullname cannot be empty !")
	@Size(min = 5, message = "Fullname required at least 5 letters")
	private String fullname;
	
	@NotNull(message = "Year of Birth cannot be empty !")
	private Integer yearOfBirth;
	
	private String country;
	
	private String[] operatingSystems;
	
	@StartsWith(prefix = "BKIT", message = "CourseName must start with BKIT")
	private String course;

	public Student() {
	}

	public Student(String id, String fullname, Integer yearOfBirth, String country, String[] operatingSystems, String course) {
		this.id = id;
		this.fullname = fullname;
		this.yearOfBirth = yearOfBirth;
		this.country = country;
		this.operatingSystems = operatingSystems;
		this.course = course;
	}
	
	public void transfer(Student source) {
		this.id = source.id;
		this.fullname = source.fullname;
		this.yearOfBirth = source.yearOfBirth;
		this.country = source.country;
		this.operatingSystems = source.operatingSystems;
		this.course = source.course;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Integer getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(Integer yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public Integer getAge() {
		return LocalDate.now().getYear() - yearOfBirth + 1;
	}
	
	public String getOsAsString() {
		return Arrays.toString(operatingSystems);
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
	
	public String getCourse() {
		return course;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fullname=" + fullname + ", yearOfBirth=" + yearOfBirth + "]";
	}
}
