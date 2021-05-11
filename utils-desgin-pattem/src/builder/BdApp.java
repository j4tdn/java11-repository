package builder;

import builder.User.Builder;

public class BdApp {
	public static void main(String[] args) {
		User u1 = User.builder().firstName("abc").age(18).build();
		
		System.out.println(u1);
	}
}
