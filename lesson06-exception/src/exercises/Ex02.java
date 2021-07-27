package exercises;

public class Ex02 {
	public static void main(String[] args) {
		boolean result = false;
		try {
			result = validate("sdfgh4567JK626");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("== MAIN ==");
		if (result) {
			System.out.println("Create account succesfully !");
		}
		
	}
	
	private static boolean validate(String password) throws Exception {
		// check all conditions
		if (password.length() < 8) {
			throw new Exception("At least 8 characters");
		}
		
		if (password.length() > 256) {
			throw new Exception("At most 256 characters");
		}
		
		// passed all conditions
		return true;
	}
}
