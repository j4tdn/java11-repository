package builder;

public class BdApp {
	public static void main(String[] args) {
		/**
		 * The builder pattern, as name implies, is an alternative way to construct
		 * complex objects. This should be used only when you want to build different
		 * immutable objects using same object building process
		 *
		 */
		User u1 = User.builder("Adam", "Kate").age(29) // builder
				.address("US") // builder
				.build();
		System.out.println(u1);

		User u2 = User.builder("Kann", "Oliver").build();
		System.out.println(u2);
	}

}
