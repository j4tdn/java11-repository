package builder;

/**
 * The builder pattern, as name implies, is an alternative way to construct complex objects. 
 * This should be used only when you want to build different immutable objects using same object building process
 *
 */
/**
 * Singleton is a creational design pattern that lets you ensure that a class
 * has only one instance, while providing a global access point to this instance
 */
public class BdApp {
	public static void main(String[] args) {
		User u1 = User.builder("Adam", "Kate").age(23).build();

		User u2 = User.builder("Adam", "Kate").build();

		System.out.println(u1);
		System.out.println(u2);
	}
}
