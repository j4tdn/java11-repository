package builder;

public class BdApp {
	public static void main(String[] args) {
		User u1 = User.builder("Adam", "Kate").age(23).address("Us").build();
		System.out.println(u1);
	}
	
}
