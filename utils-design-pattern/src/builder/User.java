package builder;

/**
 * The builder pattern, as name implies, is an alternative way to construct complex objects. 
 * This should be used only when you want to build different immutable objects using same object building process
 *
 */
public class User {
	private String fistName;
	private String lastName;
	private int agel;
	private String phone;
	private String address;
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(Builder builder) {
		this.fistName = builder.fistName;
		this.lastName = builder.lastName;
		this.agel = builder.agel;
		this.phone = builder.phone;
		this.address = builder.adress;
		
	}
	public static Builder builder(String firstName, String lastName) {
		return new Builder(firstName, lastName);
	}
	public String getFistName() {
		return fistName;
	}


	public String getLastName() {
		return lastName;
	}

	public int getAgel() {
		return agel;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}


	@Override
	public String toString() {
		return "Builder [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public static class Builder{
		private String fistName;
		private String lastName;
		private int agel;
		private String phone;
		private String address;
		
		private Builder(String firstName,String lastName) {
			this.fistName = firstName;
			this.lastName = lastName;
		}
		public Builder age(int agel) {
			this.agel = agel;
			return this;
		}
		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}
		public Builder adress(String adress) {
			this.address = address;
			return this;
		}
		public User build() {
			
			return new User(this);
		}
	}

	
}

