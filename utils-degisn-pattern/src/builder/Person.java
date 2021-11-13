package builder;

public class Person {
	private String firstName;
	private String lastName;
	private String hobbies;
	private int age;

	// Will be initial from Builder
	private Person(Builder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.hobbies = builder.hobbies;
	}

	public static Builder builder() {
		return new Builder();
	}

	// no getter, builder takes care
	// getter
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
	}

	@Override
	public String toString() {

		return firstName + "\t" + age + "\t" + hobbies + "\t" + lastName;
	}

	public static class Builder {
		private String firstName;
		private String lastName;
		private String hobbies;
		private int age;

		public Builder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder setHobbies(String hobbies) {
			this.hobbies = hobbies;
			return this;
		}

		public Builder setAge(int age) {
			this.age = age;
			return this;
		}

		private Builder() {
		}

		public Person build() {
			return new Person(this);
		}
	}
}
