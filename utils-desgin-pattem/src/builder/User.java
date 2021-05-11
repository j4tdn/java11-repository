package builder;

/**
 * The builder pattern, as name implies, is an alternative way to construct complex objects. 
 * This should be used only when you want to build different immutable objects using same object building process
 *
 */
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
		this.age = builder.age ;
		this.phone = builder.phone;
		this.address = builder.address;
	}
	
	public static Builder builder() {
		return new Builder();
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



	public static class Builder{
		private String firstName;
		private String lastName;
		private int age;
		private String phone;
		private String address;
		
		private Builder() {
		}
		
		public Builder firstName(String firtstName) {
			this.firstName = firtstName;
			return this;
		}
		
		public Builder lastName(String lastName) {
			this.firstName = lastName;
			return this;
		}
		public Builder age(int age) {
			this.age = age;
			return this;
		}
		public Builder phone(String adress) {
			this.address = address;
			return this;
		}
		public User build() {
			return new User(this);
		}
	}
}
