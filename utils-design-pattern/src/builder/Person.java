package builder;

public class Person {
	private String firstName;
	private String lastName;
	private String hobbies;
	private int age;
	
	// will be initial from builder
	private Person(Builder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.hobbies = builder.hobbies;
		this.age = builder.age;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	// no setter, builder takes care
	//getter
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getHobbies() {
		return hobbies;
	}

	public int getAge() {
		return age;
	};
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", hobbies=" + hobbies + ", age=" + age
				+ "]";
	}

	
	// nested class
	public static class Builder {
		private String firstName;
		private String lastName;
		private String hobbies;
		private int age;
		
		// this = builder
		private Builder() {
			
		}
		// similar to setter but not return void, return current object
		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public Builder hobbies(String hobbies) {
			this.hobbies = hobbies;
			return this;
		}
		
		public Builder age(int age) {
			this.age = age;
			return this;
		}
		
		public Person build() {
			return new Person(this);
		}
	}
	
}
