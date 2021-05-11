package builder;

public class Build {
	public static void main(String[] args) {
		User u1 = User.builder().firstName("abc").age(18).build();
		
		System.out.println(u1);
	}
}
