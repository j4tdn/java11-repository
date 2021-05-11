package builder;

public class Bdapp {
	public static void main(String[] args) {
		User u1 = User.builder("Adam", "Kate")
				      .age(29) // builder
				      .address("US") // builder
				      .build();
		System.out.println(u1);
		
		User u2 = User.builder("Kann", "Oliver").build();
		System.out.println(u2);
	}
}
