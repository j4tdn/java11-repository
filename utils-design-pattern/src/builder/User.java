package builder;

import jdk.jshell.JShell.Builder;
/**
 * The builder pattern, as name implies, is an alternative way to construct complex objects. 
 * This should be used only when you want to build different immutable objects using same object building process
 */
public class User {
	private String firstName;
	private String lastName;
	private int age;
	private String phone;
	private String address;
	private User() {
		
	}
	// User u1 = b1.build();
	// this -> u1
	private User(Builder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}
	public static Builder builder(String firstName, String lastName) {
		return new Builder(firstName, lastName);
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", phone=" + phone
				+ ", address=" + address + "]";
	}
	public static class Builder {
		private String firstName;
		private String lastName;
		private int age;
		private String phone;
		private String address;

		// mandatory firstName, lastName
		private Builder(String firstName, String lastName) { // this
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public Builder age(int age) {
			this.age = age;
			return this;
		}

		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}
		public Builder address(String address) {
			this.phone = address;
			return this;
		}
		public User build() {
			return new User(this);
		}
	}
}
