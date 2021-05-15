package builder;

public class User {
	private String firstname;
	private String lastname;
	private int  age;
	private String phone;
	private String address;
	
	public User() {
		
	}
	
	private User(Builder builder) {
		this.firstname = builder.firstName;
		this.lastname = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}
	public static Builder builder(String fisrtName, String lastName) {
		return new Builder(fisrtName,lastName);
	}

	public String getFirstname() {
		return firstname;
	}

	

	public String getLastname() {
		return lastname;
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
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", phone=" + phone
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
			this.address = address;
			return this;
		}
		public User build() {
			return new User(this);
		}

	
	}

}