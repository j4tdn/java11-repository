package builder;

import builder.Person.Builder;

public class Demo {
	public static void main(String[] args) {
		Person kate = Person.builder()
							.firstName("Kate")
							.lastName("Oliver")
							.age(20)
							.build();
		Person adam = Person.builder()
						.firstName("adam")
						.hobbies("Game")
						.build();
		System.out.println(kate);
	}
}
