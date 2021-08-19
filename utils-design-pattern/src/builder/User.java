package builder;

public class User {
	private String firstName;
	private String lastName;
	private int age;
	private String phone;
	private String address;
	
	private User() {
		
	}
	
	private User(Builder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}
	//User u1 = b1.build();
	//this => u1
	public static Builder builder(String firstName, String lastName) {
		return new Builder(firstName,lastName);
	}
	
	//getter
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
	//Builder b1 = new Builder().first(" ").....build();
	//b1 => u1
	//nested class  -- java do not nested function
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", phone=" + phone
				+ ", address=" + address + "]";
	}

	public static class Builder	{
		private String firstName;
		private String lastName;
		private int age;
		private String phone;
		private String address;
		
		//mandatory first name, last name
		private Builder(String firstName, String lastName) { // this
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public User build() {
			return new User(this);
		}
		
//		public Builder firstName(String firstName) {
//			this.firstName = firstName;
//			return this;
//		}
//		
//		public Builder lastName(String lastName) {
//			this.lastName = lastName;
//			return this;
//		}
		
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
	}
	
}
